package com.example.springopp;

import com.example.springopp.discount.DiscountPolicy;
import com.example.springopp.discount.RateDiscountPolicy;
import com.example.springopp.member.MemberRepository;
import com.example.springopp.member.MemberService;
import com.example.springopp.member.MemberServiceImpl;
import com.example.springopp.member.MemoryMemberRepository;
import com.example.springopp.order.OrderService;
import com.example.springopp.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
