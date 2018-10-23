package com.tns.maraton.util;

import com.tns.maraton.exceptions.BusinessException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.misc.IOUtils;

import java.io.*;

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

    private MultipartFile createMultipart(File file) throws IOException {
        return new MockMultipartFile(FILE_NAME, new FileInputStream(file));
    }
}
