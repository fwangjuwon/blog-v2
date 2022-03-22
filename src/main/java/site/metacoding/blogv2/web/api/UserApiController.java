package site.metacoding.blogv2.web.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.service.UserService;
import site.metacoding.blogv2.web.api.dto.ResponseDto;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/join")
    public ResponseDto<String> join(@RequestBody JoinDto joinDto) { // 여기에서 JoinDto 로 못받는 이유: 기본 파싱 전략이 x-www인데 json으로
        // 받았기 때문에!! json으로 받아서 파싱해줘야한다. (requestbody 붙여서)

        userService.회원가입(joinDto);

        return new ResponseDto<String>(1, "회원가입성공", null);
    }
}
