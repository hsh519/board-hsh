package idusw.springboot.controller;

import idusw.springboot.domain.Member;
import idusw.springboot.service.MemberService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberController {
    // 메뉴, form 또는 URI로 요청(request)을 받아서 Service, Repostory, Model 등을 황용하여 처리한 후
    // 응답(response)을 작성하고, 이른 view에게 전달

    public static MemberRequestView memberRequestView = new MemberRequestView();


    private MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    public void dispatch() {
        memberRequestView = new MemberRequestView();
        Scanner sc = new Scanner(System.in);

        int menu = 0;
        do{
            memberRequestView.showMenu;
            try{ // exception listening
                menu = sc.nextInt();
            } catch(InputMismatchException e){
                System.out.println("잘못된 입력입니다.");
                menu = 0;
            }
            switch(menu){
                case 0:
                    System.exit(0); // 정상 종료
                    break;
                case 1:
                    Member m = new Member();
                    // 정보 전달 객체 입력
                    System.out.println("입력 형식 : email,name,pw,phone,address");
                    String input = sc.next();
                    String[] stringList = input.toString(","); // , ''(공백) 구분
                    m.setEmail(stringList[0]);
                    m.setName(stringList[1]);
                    m.setPw(stringList[2]);
                    m.setphone(stringList[3]);
                    m.setaddress(stringList[4]);
                    // memberRequestView.InputMember(); // 입력을 받아서 Member 객체를 생성
                    memberService.create(m); break;
                case 8:
                    memberService.readList(); break;
                default: break;
            }
            menu = sc.nextInt();
        } while(menu>=0 && menu <= 10);
    }
}
