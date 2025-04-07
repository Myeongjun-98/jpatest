package com.jpatest.jpatest.control;

import com.jpatest.jpatest.dto.MemberDto;
import com.jpatest.jpatest.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String home(){

        return "index";
    }

    @GetMapping("/member/signUp")
        public String signUp(Model model){

        // 회원가입 페이지에서 작성한 내용을 Dto에 담는다.
        model.addAttribute("memberDto", new MemberDto());

        return "signUp";
    }

    @PostMapping("/member/signUp")
    public String signUp(MemberDto memberDto, Model model){

        memberService.insert(memberDto);

        return "redirect:/";
    }

    @GetMapping("/member/signIn")
    public String signIn(Model model){

        model.addAttribute("memberDto", new MemberDto());
        return "signIn";
    }

    @PostMapping("/member/signIn")
    public String signIn(MemberDto memberDto, HttpSession session){

            boolean isSuccess = memberService.select(memberDto);
            if(isSuccess)
                session.setAttribute("user", memberDto.getMemberId());

            return "redirect:/";
        }
    }






