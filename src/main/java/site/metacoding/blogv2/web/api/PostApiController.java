package site.metacoding.blogv2.web.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.PostService;
import site.metacoding.blogv2.web.api.dto.ResponseDto;
import site.metacoding.blogv2.web.api.dto.post.DetailResponseDto;
import site.metacoding.blogv2.web.api.dto.post.WriteDto;

//api 컨트롤러는 데이터 전용파일 리턴
//그냥 컨트로러는 파일 리턴 

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;
    private final HttpSession session;

    @GetMapping("/api/post")
    public ResponseDto<?> list(Integer page) {
        Page<Post> posts = postService.글목록(page);
        // 응답의 dto를 만들어서 posts를 옮김 (라이브러리 있음)
        return new ResponseDto<>(1, "성공", posts);
    }

    @PostMapping("/s/post")
    public ResponseDto<?> write(@RequestBody WriteDto writeDto) {

        User principal = (User) session.getAttribute("principal");
        Post post = writeDto.toEntity(principal);

        // 원래는 그냥 dto로 바로 넘겼는데, 지금 dto를 넘기면 session값 두개 넘겨야해서 하나로 합쳐서 넘김
        postService.글쓰기(post);

        return new ResponseDto<>(1, "성공", null);
    }

    @GetMapping("/api/post/{id}")
    public ResponseDto<?> detail(@PathVariable Integer id) {
        Post postEntity = postService.글상세보기(id);
        User principal = (User) session.getAttribute("principal");
        boolean auth = false;

        if (principal != null) {

            if (principal.getId() == postEntity.getUser().getId()) {
                auth = true;
            }
        }

        DetailResponseDto detailResponseDto = new DetailResponseDto(postEntity, auth);
        return new ResponseDto<>(1, "성공", detailResponseDto);
    }

}
