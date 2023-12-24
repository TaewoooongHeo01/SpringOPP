package com.example.springopp.singleton;

import com.example.springopp.AppConfig;
import com.example.springopp.member.MemberRepository;
import com.example.springopp.member.MemberServiceImpl;
import com.example.springopp.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void ConfigurationSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberRepository1 = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl memberRepository2 = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        System.out.println("memberRepository1: " + memberRepository1.getMemberRepository());
        System.out.println("memberRepository2: " + memberRepository2.getMemberRepository());
        System.out.println("memberRepository: " + memberRepository);

        assertThat(memberRepository1.getMemberRepository()).isSameAs(memberRepository);
        assertThat(memberRepository2.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void ConfigurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println(bean.getClass());
    }
}
