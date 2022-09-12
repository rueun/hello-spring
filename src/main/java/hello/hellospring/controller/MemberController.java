package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// Controller에서 외부 요청을 받고
@Controller
public class MemberController {
    private final MemberService memberService;


    // Controller와 Service를 연결
    // Controller 가 생성될 때 Spring Bean에 등록되어 있는 MemberService를 가져다가 넣어줌(DI : 의존 관계 주입)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
