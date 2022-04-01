package site.metacoding.blogv2.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.post.PostRepository;

// 웹 브라우저 > 컨트롤러 > 서비스 > 레파지토리 > 영속성컨텍스트 > 디비

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void 글쓰기(Post post) {
        postRepository.save(post);
    }

    public Page<Post> 글목록(Integer page) {
        PageRequest pq = PageRequest.of(page, 3, Sort.by(Sort.Direction.DESC, "id"));
        return postRepository.findAll(pq);
    }

    public Post 글상세보기(Integer id) {
        Optional<Post> postOp = postRepository.findById(id);
        if (postOp.isPresent()) {
            return postOp.get();
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void 글삭제하기(Integer id) {
        postRepository.deleteById(id);
    }
}
