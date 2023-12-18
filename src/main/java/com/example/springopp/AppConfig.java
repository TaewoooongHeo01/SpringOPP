package com.example.springopp;

import com.example.springopp.discount.DiscountPolicy;
import com.example.springopp.discount.FixDiscountPolicy;
import com.example.springopp.discount.RateDiscountPolicy;
import com.example.springopp.member.MemberRepository;
import com.example.springopp.member.MemberService;
import com.example.springopp.member.MemberServiceImpl;
import com.example.springopp.member.MemoryMemberRepository;
import com.example.springopp.order.OrderService;
import com.example.springopp.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
