package com.pard.seminar3.user.repo;

import com.pard.seminar3.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {//레포를 만들때 interface로 그리고 extends 해서 넣기
    //save,delete,patch는 알아서 해줘서 안 넣어줘도 됨
    //변수명은 save2 이런거 안됨
    //이메일이 가장 긴 사람 찾아줘-> 이런거는 직접 구현을 해야 함
    //interface 표준 명세서느낌으로 거기 있는 거만 사용할 수 있음
    //hibernate 문제 -> jpa 문제인가보다 알기(인터페이스 확인)
    public User findByEmail(String email);//findBy이후 지원(entity안 변수)
    //복잡한 조건일때는 엄청 복잡해서 sql문을 쓰게 됨 -> findByNameGreaterThan----
    //변수명이 모호하거나 길면 통역할때 오류가 날 수 있음
}
