package com.example.springopp.DITest;

import com.example.springopp.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class OptionTest {

    @Test
    void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    @Component
    static class TestBean {

        @Autowired(required = false)
        public void setBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired(required = false)
        public void setBean3(Optional<Member> memberOption) {
            System.out.println("memberOption = " + memberOption);
        }
    }
}
