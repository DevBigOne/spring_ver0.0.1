package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //스프링이 컨테이너에 있는 멤버서비스를 연결해줌
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

}
