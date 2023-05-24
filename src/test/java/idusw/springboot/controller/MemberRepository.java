package idusw.springboot.controller;

import idusw.springboot.domain.Member;

import java.util.List;

public interface MemberRepository {
    int insert(Member m); // create
    Member select(Member m); // read : m.getName()
    // Member selectByName(String name); // read
    List<Member> selectList();
    int update(Member m); // update
    int delete(Member m); // delete
}
