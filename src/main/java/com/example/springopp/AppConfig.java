package com.example.springopp;

import com.example.springopp.discount.FixDiscountPolicy;
import com.example.springopp.member.MemberService;
import com.example.springopp.member.MemberServiceImpl;
import com.example.springopp.member.MemoryMemberRepository;
import com.example.springopp.order.OrderService;
import com.example.springopp.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
