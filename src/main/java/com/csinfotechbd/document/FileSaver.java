package com.csinfotechbd.document;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${image.location}")
	private String IMAGE_DIRECTORY;

	public void saveImageToFolder(MultipartFile file, String generatedName, String ext) {

		String folder = IMAGE_DIRECTORY + File.separator;
		File temp = new File(folder);
		
		if (!temp.exists()) {
			logger.debug("Status : " + folder + " is not found");
			temp.mkdirs();
			logger.debug("Status : " + folder + " creation succesful");
		}

		String fileNameWithExt = generatedName + "." + ext;

		try {
			File f2 = new File(folder + fileNameWithExt);
			logger.debug("Status : File is transfering");
			file.transferTo(f2);
			logger.debug("Status : File is transfered");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
