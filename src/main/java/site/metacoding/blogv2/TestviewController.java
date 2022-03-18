package site.metacoding.blogv2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestviewController {

    // 모든 페이지 잘 작동하는지 확인하자! (커밋 2. 컨트롤러 페이지 작동 테스트)
    @GetMapping("/test/post/detail")
    public String detail() {
        return "post/detail";
    }

    @GetMapping("/test/post/list")
    public String list() {
        return "post/list";
    }

    @GetMapping("/test/post/updateForm")
    public String updateForm() {
        return "post/updateForm";
    }

    @GetMapping("/test/post/writeForm")
    public String writeForm() {
        return "post/writeForm";
    }

    @GetMapping("/test/user/detail")
    public String userdetail() {
        return "user/detail";
    }

    @GetMapping("/test/user/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/test/user/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/test/user/updateForm")
    public String userUpdate() {
        return "user/updateForm";
    }

}
