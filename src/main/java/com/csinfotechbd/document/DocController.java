package com.csinfotechbd.document;

import java.security.Principal;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csinfotechbd.users.User;

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
	
	@GetMapping("/addUserPer/{id}")
	public String addUserPermission(Model model,@PathVariable String id, HttpSession session, Principal principal){
		Document doc = docService.getDocumentWithUser(Integer.parseInt(id));
		HashMap<Integer, String> u = new HashMap<>();
		for(User user : doc.getUsers()){
			u.put(user.getUserId(), user.getUserId().toString());
		}
		
		DocUserDto docUserDto = new DocUserDto();
		Document docs = docService.getDocId(Integer.parseInt(id));
		docUserDto.setDocId(docs.getDocId());
		docUserDto.setName(docs.getName());
		docUserDto.setUserId(u);
		
		HashMap<Integer, String> userDoc = new HashMap<>();
		for(User user : doc.getUsers()){
			userDoc.put(user.getUserId(), user.getUserId().toString());
		}
		
		model.addAttribute("userDoc", userDoc);
		model.addAttribute("docUserDto", docUserDto);
		model.addAttribute("user", userService.getUser());
		
		return "/doc/add-user-perm";	
	}
	
}
