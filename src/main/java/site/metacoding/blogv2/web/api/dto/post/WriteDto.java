package site.metacoding.blogv2.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.user.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriteDto {

    private String title;
    private String content;

    // session 객체를 받아야함 그래서 dto를 user오브젝트로 변경해야 save(user)가능하다
    public Post toEntity(User principal) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setUser(principal);
        post.setPageCount(0);
        return post;
    }
}
