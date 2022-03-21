package site.metacoding.blogv2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.UserRepository;

@RequiredArgsConstructor // 이렇게 해야 di가 된다. final 도 적어야한다. repository앞에
@Service // component scan시에 IoC컨테이너에 등록됨 트랜잭션 관리하는 오브젝트임
public class UserService {

    private final UserRepository userRepository;

}
