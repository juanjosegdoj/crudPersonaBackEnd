package com.tns.maraton.util;

import com.tns.maraton.exceptions.BusinessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FileUtil {

    private FileUtil(){super();}

    public static File convert(MultipartFile file) throws IOException {
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
}
