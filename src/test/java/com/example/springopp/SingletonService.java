package com.example.springopp;

public class SingletonService {

    //1.static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //2.객체 인스턴스가 필요한 public으로 만든 이 메서드를 통해서만 접근이 가능하도록 만든다
    public static SingletonService getInstance() {
        return instance;
    }

    //3.생성자를 private으로 선언 -> 외부에서 new 키워드를 사용하지 못하도록 설정
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }
}
