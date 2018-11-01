package com.tns.maraton.util;

import com.tns.maraton.exceptions.BusinessException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.AssertTrue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUtilTest {

    private static final String FILE_NAME = "julian3.jpeg";

    @Test
    public void debeConvertirArchivo(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE_NAME).getFile());
        Assert.assertTrue(null!=file);
    }

    @Test(expected = BusinessException.class)
    public void debeLanzarExepcion() throws IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE_NAME).getFile());
        File convert = FileUtil.convert(createMultipart(file));
        Assert.assertTrue(null!=convert);
    }

    @Test()
    public void mustValidateFileExtension() throws IOException{

        FileUtil fileUtil = new FileUtil();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE_NAME).getFile());

        boolean isExtensionValid = FileUtil.validateExtension(file);


        Assert.assertTrue(isExtensionValid);
    }

    @Test()
    public void mustValidateFileExtensionIsWrong() throws IOException{

        FileUtil fileUtil = new FileUtil();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());

        boolean isExtensionValid = FileUtil.validateExtension(file);


        Assert.assertFalse(isExtensionValid);
    }



    private MultipartFile createMultipart(File file) throws IOException {
        return new MockMultipartFile(FILE_NAME, new FileInputStream(file));
    }
}
