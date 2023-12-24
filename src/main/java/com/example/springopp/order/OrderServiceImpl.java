package com.example.springopp.order;

import com.example.springopp.discount.DiscountPolicy;
import com.example.springopp.member.Member;
import com.example.springopp.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

   private final MemberRepository memberRepository;
   private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //Configuration 테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
