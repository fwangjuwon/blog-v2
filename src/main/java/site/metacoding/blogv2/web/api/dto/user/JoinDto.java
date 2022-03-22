package site.metacoding.blogv2.web.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv2.domain.user.User;

//dto의 역할: 외부에서 데이터를 받아서, 다시 데이터베이스 오브젝트로 바꿔준다.(통신으로 전달하거나 받는 오브젝트를 엔티티 타입으로 변환)

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JoinDto {
    private String username;
    private String password;
    private String email;
    private String addr;

    public User toEntity() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setAddr(this.addr);
        return user;
    }
}
