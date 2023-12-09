package com.example.springopp.order;

import com.example.springopp.discount.DiscountPolicy;
import com.example.springopp.discount.FixDiscountPolicy;
import com.example.springopp.member.Member;
import com.example.springopp.member.MemberRepository;
import com.example.springopp.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
