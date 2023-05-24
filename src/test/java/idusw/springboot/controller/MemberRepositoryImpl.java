package idusw.springboot.controller;

import idusw.springboot.domain.Member;
import idusw.springboot.service.MemberService;
import idusw.springboot.service.MemberServiceImpl;

public class MemberServiceImpl implements MemberService {
    private final MemberResponsitory memberRespository;
    private MemberRespository memberResponsitory;
    public MemberServiceImpl(MemberResponsitory memberResponsitory){
        // Service에서 Responsitory를 사용할 수 있도록 주입함
        this.memberRespository = memberResponsitory;
    }
    public int insert(Member m) {
        System.out.println("MemberRepository : insert() 호출 = Data Access");
        System.out.format("%10s %10s %10s %20s %50s\n", m.getEmail(),m.getName(),m.getPhone(),m.getAddress());

        return 0;
    }
    private void sayHello() {
        // memberRespository 가 필요로 하는 정보로 ㅏㄱ공
        // 가공된 정보를 memberRespository 객체에게 전달, 처리 결과를 반환 받음
        // 처리된 결과를 가공해서(업무 처리) memberController 객체에게 반환
    }
}
