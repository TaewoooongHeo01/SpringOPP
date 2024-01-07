//package com.example.springopp.findBean;
//
//import com.example.springopp.AutoAppConfig;
//import com.example.springopp.member.MemberService;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import com.example.springopp.member.MemberServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.NoSuchBeanDefinitionException;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class beanfind {
//
//    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//
//    //getBeanDefinitionNames: 모든 빈 조회
//    //getBean: 빈이름, 타입으로 빈을 특정 빈을 찾을 수 있다
//    @Test
//    @DisplayName("모든 빈 출력하기")
//    void findAllBean() {
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            Object bean = ac.getBean(beanDefinitionName);
//            System.out.println("name=" + beanDefinitionName + " object=" + bean);
//        }
//    }
//
//    @Test
//    @DisplayName("애플리케이션 빈 출력")
//    void findApplicationBean() {
////        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
////        for (String beanDefinitionName : beanDefinitionNames) {
////            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
////            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
////                Object bean = ac.getBean(beanDefinitionName);
////                System.out.println("name: "+beanDefinitionName+" object: "+bean);
////            }
////        }
//    }
//
//    //ac.getBean(빈이름, 타입)
//    //ac.getBean(타입)
//    //조회 대상 스프링 빈이 없으면 예외 발생
//    @Test
//    @DisplayName("이름으로 조회")
//    void findBeanByName() {
//        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }
//
//    @Test
//    @DisplayName("이름없이 타입만으로 조회")
//    void findBeanByType() {
//        MemberService memberService = ac.getBean(MemberService.class);
//        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }
//
//    @Test
//    @DisplayName("구체타입으로 조회")
//    void findBeanByEmbodiment() {
//        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
//        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }
//
//    @Test
//    @DisplayName("존재하지 않는 빈")
//    void cantFindBean() {
//        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
//                () -> ac.getBean("xxxx", memberService));
//    }
//}
