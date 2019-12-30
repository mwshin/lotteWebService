package com.lotteproject.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lotteproject.webservice.domain.PostsRepository;
import com.lotteproject.webservice.dto.PostsMainResponseDto;
import com.lotteproject.webservice.dto.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {

	private PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional
	public void del(PostsSaveRequestDto dto) {
		
		List<String> delList = dto.getDelList();
		
		for(String val : delList) {
			Long id = Long.parseLong(val);
			postsRepository.deleteById(id);
		}
	}
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc() {
       return postsRepository.findAllDesc()
               .map(PostsMainResponseDto::new)
               .collect(Collectors.toList());
    }
	
}
