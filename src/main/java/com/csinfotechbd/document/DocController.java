package com.csinfotechbd.document;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/doc")
public class DocController {
	
	@Autowired
	private DocService docService;
	
	@GetMapping("/form")
	public String getDocUploadForm(){
		return "doc/upload-form";
	}
	
	@PostMapping("/upload")
	public String getUploadedDoc(DocBearer bearer){
		if(bearer != null){
			docService.saveFile(bearer);
		}
		return "/doc/upload-form";
	}
	
	@GetMapping("/view/{fileId}")
	@ResponseBody
	public String getFile(@PathVariable(name="fileId") long fileId){
		
		docService.getFile(fileId);
		return "";
	}
	
}
