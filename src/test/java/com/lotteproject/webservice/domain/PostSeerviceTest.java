//package com.lotteproject.webservice.domain;
//
//import org.aspectj.lang.annotation.After;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.lotteproject.webservice.dto.PostsSaveRequestDto;
//import com.lotteproject.webservice.service.PostsService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PostSeerviceTest {
//
//	@Autowired
//    private PostsService postsService;
//
//    @Autowired
//    private PostsRepository postsRepository;
//
//    @After
//    public void cleanup () {
//        postsRepository.deleteAll();
//    }
//
//    @Test
//    public void Dto데이터가_posts테이블에_저장된다 () {
//        //given
//        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
//                .author("jojoldu@gmail.com")
//                .content("테스트")
//                .title("테스트 타이틀")
//                .build();
//
//        //when
//        postsService.save(dto);
//
//        //then
//        Posts posts = postsRepository.findAll().get(0);
//        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
//        assertThat(posts.getContent()).isEqualTo(dto.getContent());
//        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
//    }
//	
//}
