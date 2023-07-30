package com.bitspondon.rokibspringboot.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

    public final static String uploadLocation = "";


    public boolean uploadFile(MultipartFile file) {

        boolean flag = false;

        try {
//            InputStream inputStream = file.getInputStream();
//            byte data[] = new byte[inputStream.available()];
//            inputStream.read(data);
//
//            FileOutputStream fileOutputStream = new FileOutputStream(uploadLocation + "\\" + file.getOriginalFilename());
//            fileOutputStream.write(data);
//            fileOutputStream.flush();
//            fileOutputStream.close();
//            flag = true;


            Files.copy(file.getInputStream(), Paths.get(uploadLocation + "\\" + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            flag = true;


        } catch (Exception e) {

        }


        return flag;

    }


}
