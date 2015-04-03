package me.jiangyu.april.core.test;

/**
 * Created by jyk on 2015/4/1.
 */
interface Interface1 {
    boolean equals(Object o);

    default void f() {
        System.out.println("f");
    }
}

interface Interface2 {
    default void f() {
        System.out.println("f");
    }
}

public class A implements Interface1, Interface2 {
    public <T> void a() {
        T t = null;
    }

    public void f() {
    }

    public static void main(String[] args) {
        A a = new A();
        a.f();
    }
}