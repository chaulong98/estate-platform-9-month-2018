package com.estate.utils;

import com.estate.constant.SystemConstant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class UploadFileUtils {



	@Value("${dir.default}")
	private static String dirDefault;

	public static void writeOrUpdate(String path, byte[] bytes) {
		path = SystemConstant.HOME_BUILDING +path;
	    File file = new File(StringUtils.substringBeforeLast(path, "/"));
	    if (!file.exists()) {
	        file.mkdir();
        }
		try(FileOutputStream fop = new FileOutputStream(path)) {
			fop.write(bytes);
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
