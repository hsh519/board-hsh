package idusw.springboot.controller;

import idusw.springboot.service.MemberService;
import org.apache.catalina.core.ApplicationContext;

public class ApplicataionContext { // Framework : 필요한 것을 만들어서 사용하는 것이 아닌
    private static ApplicationContext applicationContext;
    private static MemberRepository memberRepository;
    private static MemberService memberService;
    private static MemberController memberController;

    public static ApplicataionContext lookup() {
        if (applicationContext == null) {
            memberRepository = new MemberRepositoryImpl();
            memberService = new MemberRepositoryImpl(memberRepository);
            memberController = new MemberController(memberService);
        }
        return new ApplicataionContext();
    }

    public static MemberService getMemberService() {
        return memberService;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static MemberController getMemberController() {
        return memberController;
    }

    public static MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
