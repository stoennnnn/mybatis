package com.zql.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: create
 * @description:
 * @date: 2019-8-22
 */
public interface IBachImportService {
    boolean batchImport(String fileName, MultipartFile file) throws IOException;
    void test();
    void test2();
}
