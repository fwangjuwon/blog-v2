package site.metacoding.blogv2.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.domain.user.UserRepository;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;
import site.metacoding.blogv2.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor // 이렇게 해야 di가 된다. final 도 적어야한다. repository앞에
@Service // component scan시에 IoC컨테이너에 등록됨 트랜잭션 관리하는 오브젝트임
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinDto joinDto) {

        // save 하면 db에 insert하고 insert된 결과를 다시 return해준다.
        userRepository.save(joinDto.toEntity());

    }

    public User 로그인(LoginDto loginDto) {
        // 로그인 처리 쿼리를 jpa에서 제공해주지 않는다.
        User userEntity = userRepository.mLogin(loginDto.getUsername(), loginDto.getPassword());
        return userEntity; // session에 넣어서 리턴해야한다.
    }

    public User 회원정보(Integer id) {
        Optional<User> userOp = userRepository.findById(id);
        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            throw new RuntimeException("id를 찾을 수 없습니다");
        }
    }

    @Transactional
    public User 회원수정(Integer id, UpdateDto updateDto) {
        // UPDATE user SET password = ?, email = ?, addr = ? WHERE id = ?
        Optional<User> userOp = userRepository.findById(id); // 영속화 (디비 row를 영속성 컨텍스에 옮김)

        if (userOp.isPresent()) {
            // 영속화된 오브젝트 수정
            User userEntity = userOp.get();
            userEntity.setPassword(updateDto.getPassword());
            userEntity.setEmail(updateDto.getEmail());
            userEntity.setAddr(updateDto.getAddr());
            return userEntity;
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다.");
        }
    } // 트랜잭션이 걸려있으면 @Service 종료시에 변경감지해서 디비에 update함 = 더티체킹
}
