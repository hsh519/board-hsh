package idusw.springboot.boradthymleaf.controller;

import idusw.springboot.boradthymleaf.domain.Member;
import idusw.springboot.boradthymleaf.service.MemberService;
import idusw.springboot.boradthymleaf.service.MemberServiceImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Data
@Controller
@RequestMapping("/members")
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "/members/login";
    }

    @PostMapping("/login")
    public String loginMember() {
        return "redirect:/";
    }

    @GetMapping("/register")
    public String getRegisterForm(@ModelAttribute Member member, Model model) {
        model.addAttribute("member", Member.builder().build());
        return "/members/register";
    }

    @PostMapping("/register")
    public String createMember(@ModelAttribute Member member) {
        member.setSeq(1L);
        log.info("member={}", member);
        if(memberService.create(member) > 0) {
            return "redirect:/";
        } else {
            return "main/error";
        }

    }

    @PutMapping("/update")
    public String updateMember() {
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String deleteMember() {
        return "redirect:/";
    }

    @GetMapping("/forgot-password")
    public String goForgotForm() {
        return "/members/forgot-password";
    }

    @PostMapping("/forgot-password")
    public String forgotMemberPassword() {
        return "redirect:/";
    }

//    @GetMapping("/buttons")
//    public String goButtons() {
//        return "/main/buttons";
//    }

//    @GetMapping("/cards")
//    public String goCards() {
//        return "/main/cards";
//    }

//    @GetMapping("/error")
//    public String go404Page() {
//        return "/main/404";
//    }
//
//    @GetMapping("/blank")
//    public String goBlank() {
//        return "/main/blank";
//    }
//
//    @GetMapping("/charts")
//    public String goCharts() {
//        return "/main/charts";
//    }
//
//    @GetMapping("/tables")
//    public String goTables() {
//        return "/main/tables";
//    }
//
//    @GetMapping("/utilities-animation")
//    public String goUtilitiesAnimation() {
//        return "/main/utilities-animation";
//    }
//
//    @GetMapping("/utilities-border")
//    public String goUtilitiesBorder() {
//        return "/main/utilities-border";
//    }
//
//    @GetMapping("/utilities-color")
//    public String goUtilitiesColor() {
//        return "/main/utilities-color";
//    }
//
//    @GetMapping("/utilities-other")
//    public String goUtilitiesOther() {
//        return "/main/utilities-other";
//    }
}
