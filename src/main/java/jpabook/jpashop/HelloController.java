package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") // 접속 url
    public String Hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // templates의 이름. html은 자동으로 붙음 (templates -> hello.html)
    }
}
