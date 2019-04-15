package study.APSS;

import java.util.LinkedList;

public class Test {
    static{
        System.out.println("static");
        ChildTest childTest;

    }
    public static void main(String[] args) {
        System.out.println(ChildTest.class);
    }
}

class ChildTest{
    static{
        System.out.println("child_static");
    }
}