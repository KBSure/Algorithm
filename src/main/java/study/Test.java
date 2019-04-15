package study;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        String s1 = "abcd";
        String s2 = new String("abcd");
        String s3 = new String("abcd");
        s2 = s3;
        String s4 = new String(s1);
        String s5 = "abcd";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
        Integer i1 = 1;
        System.out.println(null == null);
        A a = new B();
        a.hi();
    }

    static abstract class A{
        public abstract void hi();
    }

    static class B extends A{
        @Override
        public void hi() {

        }
    }
}
