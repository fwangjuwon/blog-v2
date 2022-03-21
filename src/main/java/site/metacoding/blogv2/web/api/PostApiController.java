package site.metacoding.blogv2.web.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.service.PostService;

//api 컨트롤러는 데이터 전용파일 리턴
//그냥 컨트로러는 파일 리턴 

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;
}
