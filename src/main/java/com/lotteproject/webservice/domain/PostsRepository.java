package com.lotteproject.webservice.domain;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long>{

    @Query("SELECT a " +
            "FROM Posts a " +
            "ORDER BY a.id DESC")
//	@Query(value = "SELECT * FROM POSTS ORDER BY ID DESC", nativeQuery = true)
	Stream<Posts> findAllDesc();
}
