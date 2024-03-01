package hello.hellospring.controller;

import org.springframework.ui.Model;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //스프링이 컨테이너에 있는 멤버서비스를 연결해줌
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping("/members/new") // 조회할 때 사용 됨
    public String createForm() {
        return "members/createMemberForm"; //createMemberForm으로 이동하는 메소드
    }

    @PostMapping("members/new") //데이터 전달할 때 post 사용
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName()); // 등록된 회원이름 꺼냄.

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String List(Model model) {
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
