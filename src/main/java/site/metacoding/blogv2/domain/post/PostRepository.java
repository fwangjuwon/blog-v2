package site.metacoding.blogv2.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

//repository는 인터페이스로 만들어야함
//내부에 @repository가 구현돼있어서 생략가능
public interface PostRepository extends JpaRepository<Post, Integer> {

}
