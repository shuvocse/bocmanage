package com.csinfotechbd.document;

import com.csinfotechbd.base.BaseService;

public interface DocService extends BaseService{
	
	public String saveFile(DocBearer bearer);

	public void getFile(long fileId);

}
