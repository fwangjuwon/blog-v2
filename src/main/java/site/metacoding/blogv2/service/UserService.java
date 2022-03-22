package site.metacoding.blogv2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.domain.user.UserRepository;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;

@RequiredArgsConstructor // 이렇게 해야 di가 된다. final 도 적어야한다. repository앞에
@Service // component scan시에 IoC컨테이너에 등록됨 트랜잭션 관리하는 오브젝트임
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinDto joinDto) {

        // save 하면 db에 insert하고 insert된 결과를 다시 return해준다.
        userRepository.save(joinDto.toEntity());
    }
}
