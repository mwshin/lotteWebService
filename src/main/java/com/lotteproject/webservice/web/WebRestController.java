package com.lotteproject.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lotteproject.webservice.dto.PostsSaveRequestDto;
import com.lotteproject.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsService postsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Helloworld";
	}
	
	@PostMapping("/savePosts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}
	
	@PostMapping("/delPosts")
	public void delPosts(@RequestBody PostsSaveRequestDto dto) {
		postsService.del(dto);
	}
}
