package com.zql.serviceImpl;

import com.zql.Exception.CommonExecption;
import com.zql.mapper.ImportMapper;
import com.zql.model.User;
import com.zql.service.IBachImportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author: create
 * @description:
 * @date: 2019-8-22
 */
@Service
public class BachImportServiceImpl implements IBachImportService {

    @Autowired
    private ImportMapper userMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws IOException {
        boolean notNull = false;
        List<User> userList = new ArrayList<>();
        if (!fileName.matches( "^.+\\.(?i)(xls)$" ) && !fileName.matches( "^.+\\.(?i)(xlsx)$" )) {
            throw new CommonExecption("505", "上传文件格式不正确" );
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
        if (sheet != null) {
            notNull = true;
        }
        //循环读取表格
        for (Row row : sheet) {
            User user = new User();
            //首行不读取
            if (row.getRowNum() == 0) {
                continue;
            }
            //读取当前行中单元格数据，索引从0开始
            String name = row.getCell( 1 ).getStringCellValue();
            String phone = row.getCell( 2 ).getStringCellValue();
            String add = row.getCell( 3 ).getStringCellValue();
            Date enrolDate = row.getCell( 4 ).getDateCellValue();
            String des = row.getCell( 5).getStringCellValue();
            user.setName( name );
            user.setPhone( phone );
            user.setAddress( add );
            user.setEnrolDate( enrolDate );
            user.setDes( des );
            userList.add( user );
        }
        //插入数据库
        for (User userResord : userList) {
            String name = userResord.getName();
            int cnt = userMapper.selectByName( name );
            if (cnt == 0) {
                userMapper.addUser( userResord );
                System.out.println( " 插入 " + userResord );
            } else {
                userMapper.updateUserByName( userResord );
                System.out.println( " 更新 " + userResord );
            }
        }
        return notNull;
    }
}

