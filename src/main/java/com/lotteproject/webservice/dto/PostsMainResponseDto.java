package com.lotteproject.webservice.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.lotteproject.webservice.domain.Posts;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {

	private Long id;
	private String title;
	private String content;
	private String author;
	private String modifiedDate;
	
	public PostsMainResponseDto(Posts entity) {
		id = entity.getId();
		title = entity.getTitle();
		content = entity.getContent();
		author = entity.getAuthor();
		modifiedDate = toStringDateTime((entity.getModidiedDate()));
	}
	
	/**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
