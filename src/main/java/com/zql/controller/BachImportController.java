package com.zql.controller;

import com.zql.Utils.ImportUtil;
import com.zql.model.User;
import com.zql.service.IBachImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author: create
 * @description:
 * @date: 2019-8-22
 */
@RestController
@RequestMapping("/batch")
public class BachImportController {

    @Autowired
    private IBachImportService bachImportService;

    @PostMapping("/import")
    public List addUser(@RequestParam("file") MultipartFile file) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        boolean a = false;
//        String fileName = file.getOriginalFilename();
//        try {
//            a = bachImportService.batchImport(fileName, file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return  a;
        User user = new User();
        List  objs= ImportUtil.getImportDatas( file, user );
        return objs;
    }
}
