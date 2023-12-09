package com.example.springopp.discount;

import com.example.springopp.member.Member;

public interface DiscountPolicy {

    /*
     *@result: 할인대상금액
     */
    int discount(Member member, int price);
}
