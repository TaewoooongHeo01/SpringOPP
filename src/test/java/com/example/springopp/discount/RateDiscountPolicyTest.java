package com.example.springopp.discount;

import com.example.springopp.member.Grade;
import com.example.springopp.member.Member;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("10프로 할인정책이 적용되어야 한다(VIP).")
    public void vipDiscount() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("10프로 할인정책이 적용되지 않아야 한다(BASIC).")
    public void basicDiscount() {
        //given
        Member member2 = new Member(2L, "member2", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member2, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}