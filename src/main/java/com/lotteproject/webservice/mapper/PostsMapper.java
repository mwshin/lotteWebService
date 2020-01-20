package com.lotteproject.webservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lotteproject.webservice.dto.PostsMainResponseDto;

@Mapper
public interface PostsMapper {

	@Select("SELECT * FROM posts")
	public List<PostsMainResponseDto> getPostsList() throws Exception;
}
