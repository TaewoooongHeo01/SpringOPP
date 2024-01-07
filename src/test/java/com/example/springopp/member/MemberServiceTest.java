package com.example.springopp.member;

import com.example.springopp.AutoAppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        ApplicationContext appConfig = new AnnotationConfigApplicationContext(AutoAppConfig.class);

//        this.memberService = appConfig.memberService();
    }


    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        //when
        memberService.join(member);
        Member member1 = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(member1);
    }
}
