package com.example.springopp.singleton;

import com.example.springopp.AppConfig;
import com.example.springopp.SingletonService;
import com.example.springopp.findBean.ApplicationContextExtendsFindTest;
import com.example.springopp.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class singleton {

    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너(싱글톤 패턴을 적용해야 하는 이유)")
    void pureContianer() {

        AppConfig appConfig = new AppConfig();

        //객체1. 호출할 때마다 새로운 객체 생성
        MemberService memberService1 = appConfig.memberService();

        //객체2. 호출할 때마다 새로운 객체 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤패턴을 적용한 객체 사용")
    void singletonServiceTest() {

        //조회1. 호출할 때마다 같은 객체 생성
        SingletonService singletonService1 = SingletonService.getInstance();
        singletonService1.setCount(100);

        //조회2. 호출할 때마다 같은 객체 생성
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1" + singletonService1.getCount());
        System.out.println("singletonService2" + singletonService2.getCount());

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링컨테이너 -> 싱글톤패턴")
    void springContainer() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean(MemberService.class);

        MemberService memberService2 = ac.getBean(MemberService.class);

        System.out.println("memberService1" + memberService1);
        System.out.println("memberService2" + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 사용할 시 주의점")
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationContextExtendsFindTest.TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        int price1 = statefulService1.order("memberA", 10000);
        int price2 = statefulService2.order("memberB", 20000);

        System.out.println("statefulService1 price="+price1);
        System.out.println("statefulService2 price="+price2);

    }
}
