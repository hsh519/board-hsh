package idusw.springboot.boradthymleaf.service;

import idusw.springboot.boradthymleaf.domain.Member;
import idusw.springboot.boradthymleaf.domain.Memo;
import idusw.springboot.boradthymleaf.entity.MemberEntity;
import idusw.springboot.boradthymleaf.entity.MemoEntity;
import idusw.springboot.boradthymleaf.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public int create(Member m) {
        MemberEntity entity = MemberEntity.builder()
                .seq(m.getSeq())
                .email(m.getEmail())
                .name(m.getName())
                .pw(m.getPw())
                .build();
        log.info("entity={}", entity);
        if(memberRepository.save(entity) != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Member read(Member m) {
        MemberEntity e = memberRepository.getById(m.getSeq());
        Member res = new Member(); // DTO (Data Transfer Object) : Controller - Service or Controller - View
        res.setSeq(e.getSeq());
        res.setEmail(e.getEmail());
        res.setName(e.getName());
        return res;
    }

    @Override
    public List<Member> readList() {
        return null;
    }

    @Override
    public int update(Member m) {
        return 0;
    }

    @Override
    public int delete(Member m) {
        return 0;
    }

    @Override
    public Member login(Member m) {
        MemberEntity e = memberRepository.getByEmailPw(m.getEmail(), m.getPw());
        Member res = new Member(); // DTO (Data Transfer Object) : Controller - Service or Controller - View
        if (e!=null) {
            res.setSeq(e.getSeq());
            res.setEmail(e.getEmail());
            res.setName(e.getName());
        }
        return res;
    }
}
