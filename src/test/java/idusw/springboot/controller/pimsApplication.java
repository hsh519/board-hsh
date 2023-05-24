package idusw.java.pims;

import idusw.java.pims.controller.MemberController;
import idusw.java.pims.model.Member;
import idusw.java.pims.service.MemberService;
import idusw.java.pims.service.MemberServiceImpl;
import idusw.java.pims.service.MemberServiceImplOther;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * MVC Model(or Pattern) : Model, View, Controller 나누어 소프트웨어 개발하는 방법론
 * MVC Model 2 + Service Pattern : 업무 로직(business logic) 세분화
 * DTO(Data Transfer Object) : 데이터 전송 객체 (주고 받는 데이터) - model, domain
 * DAO(Data Access Object) : 데이터 접근 객체 (데이터 처리 - Memory, File, DB) - Repository
 * Web - HTTP : Request-Response Model
 */
public class PimsApplication {
    public static void main(String[] args) {
        // 생성자로 객체를 주입 <-- Framework 가 수행함
        //MemberService memberService = new MemberServiceImplOther(); //new MemberServiceImpl(); //
        // 인터페이스 통한 객체를 주입하기 때문에 결합도가 낮음(loosely coupled), 교체가 용이함
        //MemberController memberController = new MemberController(memberService); // 다형성(polymorphism)

        // Framework 에 생성된 객체들을 스캔(scan)
        ApplicationContext applicationContext = ApplicationContext.lookup();
        MemberController memberController = ApplicationContext.getMemberController();

        if(memberController != null)
            memberController.dispatch(); // 디스패처 역할을 활성화함
        else
            System.out.println("error");
        InputStreamReader isr = new InputStreamReader(System.out);
        BufferedReader br = new BufferedReader(isr);
        try {
            int c = isr.read(); // checked exception
        }catch(IOException e){

        }

        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("0.종료, 1.등록, 2.로그인, 3.조회, 4.수정, 5.탈퇴, 8.목록조회, 9.로그아웃");
        int command = sc.nextInt();

        switch(command) {
            case 1:
                Member m = new Member();
                // 정보 전달 객체 입력
                memberController.registerRequest(m); break;
            case 8: memberController.listRequest(); break;
            default: break;
        }
        */
    }
}