package com.bitspondon.rokibspringboot.controller;

import com.bitspondon.rokibspringboot.util.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {


    @Autowired
    FileUploadHelper fileUploadHelper;

    @PostMapping("upload-file")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        boolean uploadFile = fileUploadHelper.uploadFile(file);
        if (uploadFile) {
            return ResponseEntity.ok("file uploaded successfully");
        } else {
            return ResponseEntity.ok("file upload is not successful");
        }
    }
}
