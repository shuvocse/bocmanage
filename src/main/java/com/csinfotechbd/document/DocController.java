package com.csinfotechbd.document;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doc")
public class DocController {
	
	@GetMapping("/form")
	public String getDocUploadForm(){
		return "doc/upload-form";
	}
	
	@PostMapping("/upload")
	public String getUploadedDoc(DocBearer bearer){
		if(bearer != null){
			System.out.println(bearer.getFile().getContentType());
			System.out.println(bearer.getFile().getOriginalFilename());
		}
		return "/doc/upload-form";
	}
	
}
