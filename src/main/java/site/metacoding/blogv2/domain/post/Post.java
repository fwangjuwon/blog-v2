package site.metacoding.blogv2.domain.post;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv2.domain.comment.Comment;
import site.metacoding.blogv2.domain.user.User;

/**
 * GET: /post/1 상세보기
 * User, Post, List<Comment>
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // primary key

    @Column(length = 300, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    // @ColumnDefault("0") // 초기 조회수 0
    @Column(nullable = false)
    private Integer pageCount;

    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @JsonIgnoreProperties({ "post" }) // messageconverter에게 알려주는 어노테이션
    @OneToMany(mappedBy = "post") // ""안에 연관관계의 주인의 변수명을 넣으면 된다.
    private List<Comment> comments;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

}
