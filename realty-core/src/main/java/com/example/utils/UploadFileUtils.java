package com.example.utils;

import com.example.constant.SystemConstant;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadFileUtils {

	private static Logger LOGGER = LoggerFactory.getLogger(UploadFileUtils.class);

	public static void writeOrUpdateBase64File(String folderFile, String base64, String fileName) {
		checkAndCreateFolder(SystemConstant.BASE_DIR, folderFile);
		FileOutputStream outputStream = null;
		try {
			String pathFile = SystemConstant.BASE_DIR  + folderFile + fileName;
			File file = new File(pathFile);
			if (file.exists()) {
				file.delete();
			}
			outputStream = new FileOutputStream(pathFile);
			byte[] decodedString = Base64.decodeBase64(base64.getBytes());
			outputStream.write(decodedString);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	private static void checkAndCreateFolder(String root, String folderFile) {
		File fileLocation = new File(root);
		if (!fileLocation.exists()) {
			fileLocation.mkdir();
		}
		File file = new File(fileLocation + folderFile);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}
