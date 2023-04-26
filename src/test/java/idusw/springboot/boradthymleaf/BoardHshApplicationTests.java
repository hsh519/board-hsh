package idusw.springboot.boradthymleaf;

import idusw.springboot.boradthymleaf.domain.Member;
import idusw.springboot.boradthymleaf.domain.Memo;
import idusw.springboot.boradthymleaf.service.MemberService;
import idusw.springboot.boradthymleaf.service.MemberServiceImpl;
import idusw.springboot.boradthymleaf.service.MemoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class BoardHshApplicationTests {

    @Autowired
    MemberService memberService;

    @Autowired
    MemoService memoService;


    @Test
    void contextLoads() {
        Member member = Member.builder()
                .email("12@com")
                .name("12")
                .pw("12")
                .build();
        if(memberService.create(member) > 0) {
            System.out.println("등록 성공");
        } else {
            System.out.println("등록 실패");
        }
    }

    @Test
    void readMember() {
        Member member = Member.builder()
                .seq(1L)
                .build();
        assertThat(memberService.read(member)).isNotNull();
    }

    @Test
    void readMemo() {
        Memo m = new Memo();
        m.setMno(1L);
        assertThat(memoService.read(m)).isNotNull();
    }
}
