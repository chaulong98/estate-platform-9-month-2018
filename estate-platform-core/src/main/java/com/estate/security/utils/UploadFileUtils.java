package com.estate.security.utils;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadFileUtils {
    public static void writeOrUpdate(String path,byte[] bytes){
        path = "/anh/test/" + path;
        File file =new File(StringUtils.substringBeforeLast(path,"/"));
        if (!file.exists()) {
            file.mkdir();
        }
        try (FileOutputStream fop = new FileOutputStream(file)) {
            fop.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
