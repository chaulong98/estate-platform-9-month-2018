package com.estate.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class UploadFileUtils {
	@Value("${dir.default}")
	private String dirDefault;

	public void writeOrUpdate(String path, byte[] bytes) {
		path = dirDefault + path;
		File file = new File(StringUtils.substringBeforeLast(path, "/"));
		if (!file.exists()) {
			file.mkdir();
		}
		try(FileOutputStream outputStream = new FileOutputStream(path)) {
			outputStream.write(bytes);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
