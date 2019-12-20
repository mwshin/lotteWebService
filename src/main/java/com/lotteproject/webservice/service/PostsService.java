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
		
		Long id = null;
		List<String> delList = dto.getDelList();
		
		for(int i=0; i < delList.size(); i++){
			id = Long.parseLong((delList.get(i)));
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
