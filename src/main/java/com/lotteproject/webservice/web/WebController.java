package com.lotteproject.webservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lotteproject.webservice.service.PostsService;

@Controller
public class WebController {

	@Autowired
	private PostsService postsService;
	
	@GetMapping("/main")
    public String main(Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
		return "main";
	}
}
