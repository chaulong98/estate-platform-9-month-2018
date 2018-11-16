package com.example.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.constant.SystemConstant;


@Controller
public class DowloadController {
	
	@RequestMapping(value = "/images/{file:.+}", produces = MediaType.ALL_VALUE)
	public @ResponseBody byte[] download(@PathVariable(value = "file") String fileName) {
		String filePath = SystemConstant.HOME_BUILDING + "/test/" + fileName ;
		File file = new File(filePath);
		try {
			return IOUtils.toByteArray(new FileInputStream(file));
		} catch (IOException e) {
			
		}
		return new byte[0];
	}
}


