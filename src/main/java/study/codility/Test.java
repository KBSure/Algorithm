package study.codility;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        System.out.println(((Object)a).getClass());
        System.out.println(((A)b).getClass());
    }
    static class A{

    }
    static class B extends A{

    }
}
