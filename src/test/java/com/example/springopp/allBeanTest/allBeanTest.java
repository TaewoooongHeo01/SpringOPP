package com.example.springopp.allBeanTest;

import com.example.springopp.AutoAppConfig;
import com.example.springopp.discount.DiscountPolicy;
import com.example.springopp.member.Grade;
import com.example.springopp.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class allBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        int discountPrice = discountService.discount(memberA, 10000, "fixDiscountPolicy");
        Assertions.assertThat(discountPrice).isEqualTo(1000);

        Member memberB = new Member(2L, "memberB", Grade.VIP);
        int discountPrice2 = discountService.discount(memberB, 20000, "rateDiscountPolicy");
        Assertions.assertThat(discountPrice2).isEqualTo(2000);
    }

    @Component
    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            System.out.println("discountPolicy = " + discountPolicy);
            System.out.println("discountCode = " + discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
