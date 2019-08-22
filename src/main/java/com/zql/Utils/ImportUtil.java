package com.zql.Utils;

import com.zql.Exception.CommonExecption;
import com.zql.model.User;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: create by zql
 * @description: excel导入工具类
 * @date: 2019-8-22
 */
public class ImportUtil {
    /**
     * 根据实体成员属性类型得到属性值
     * @param realValue
     * @param fields
     * @param f
     * @param cellValue
     * @return
     */
    private static Object getEntityMemberValue(Object realValue, Field[] fields, int f, String cellValue)
    {
        String type = fields[f].getType().getName();
        switch (type)
        {
            case "char":
            case "java.lang.Character":
            case "java.lang.String":
                realValue = cellValue;
                break;
            case "java.util.Date":
                realValue = StringUtils.isBlank(cellValue) ? null : DateUtil.strToDate(cellValue, DateUtil.YYYY_MM_DD);
                break;
            case "java.lang.Integer":
                realValue = StringUtils.isBlank(cellValue) ? null : Integer.valueOf(cellValue);
                break;
            case "int":
            case "float":
            case "double":
            case "java.lang.Double":
            case "java.lang.Float":
            case "java.lang.Long":
            case "java.lang.Short":
            case "java.math.BigDecimal":
                realValue = StringUtils.isBlank(cellValue) ? null : new BigDecimal(cellValue);
                break;
            default:
                break;
        }
        return realValue;
    }

    /**
     * 根据类型获得单元格值
     * @param cell
     * @return
     */
    private static String getCellValue(Cell cell) {
        String cellValue = "";
        if (null != cell) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC: // 数字
                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted( cell )) {
                        Date theDate = cell.getDateCellValue();
                        //todo 格式化日期
                        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
                        cellValue = sdf.format( theDate );
                    } else {
                        DecimalFormat df = new DecimalFormat( "0" );
                        cellValue = df.format( cell.getNumericCellValue() );
                    }
                    break;
                case STRING: // 字符串
                    cellValue = cell.getStringCellValue();
                    break;
                case BOOLEAN: // Boolean
                    cellValue = cell.getBooleanCellValue() + "";
                    break;
                case FORMULA: // 公式
                    cellValue = cell.getCellFormula() + "";
                    break;
                case BLANK: // 空值
                    cellValue = "";
                    break;
                case ERROR: // 故障
                    cellValue = "非法字符";
                    break;
                default:
                    cellValue = "未知类型";
                    break;
            }
        }
        return cellValue;
    }

    public static List getImportDatas(MultipartFile file,Object objcet) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //读取文件名
        String fileName = file.getOriginalFilename();
        if (!fileName.matches( "^.+\\.(?i)(xls)$" ) && !fileName.matches( "^.+\\.(?i)(xlsx)$" )) {
            throw new CommonExecption( "KLM500000002", "上传文件格式不正确" );
        }
        boolean isExcel2003 = true;
        if (fileName.matches( "^.+\\.(?i)(xlsx)$" )) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook( is );
        } else {
            wb = new XSSFWorkbook( is );
        }
        //得到工作表对象
        Sheet sheet = wb.getSheetAt( 0 );
        if (null  == sheet) {
          throw new CommonExecption( "KLM500000001","导入表格数据为空" );
        }
        //利用反射获取实体属性
        Field[] fields = objcet.getClass().getDeclaredFields();
        //属性值
        Object entityMemberValue = "";
        //cell值
        String cellValue = "";
        List <Object> ts = new ArrayList <>();
        for (Row row : sheet) {
            User user = new User();
            //首行不读取
            if (row.getRowNum() == 0) {
                continue;
            }
            //封装属性值
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                String fieldName = fields[i].getName();
                Cell cell = row.getCell( i );
                cellValue = getCellValue( cell );
                entityMemberValue = getEntityMemberValue( objcet, fields, i, cellValue );
                PropertyUtils.setProperty( objcet,fieldName, entityMemberValue);
            }
            ts.add( objcet );
        }
        return ts;
    }
}
