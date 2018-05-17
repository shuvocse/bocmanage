package com.csinfotechbd.document;

import org.springframework.web.multipart.MultipartFile;

import com.csinfotechbd.base.BaseService;

public interface DocService extends BaseService{
	
	public String saveFile(DocBearer bearer);

}
