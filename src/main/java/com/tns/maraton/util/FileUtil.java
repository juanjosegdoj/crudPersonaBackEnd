package com.tns.maraton.util;

import com.tns.maraton.exceptions.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public final class FileUtil {

    public FileUtil(){
        super();
    }

    public static File convert(MultipartFile file) {
        try{
            File convFile = new File(file.getOriginalFilename());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            return convFile;
        }catch (IOException e){
            throw new BusinessException(Constants.FILE_ERROR, e);
        }
    }

    public static boolean validateExtension(File file) {
        String name = file.getName();
        int n = name.indexOf(".");
        String sb = name.substring(n);
        if (sb.equals(".jpeg") || sb.equals(".jpg") || sb.equals(".png")){
            return true;
        }else{
            return false;
        }
    }
}
