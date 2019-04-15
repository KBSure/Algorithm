package Line.test;

import java.util.HashMap;
import java.util.Map;

public class Test4 {
    public static void main(String[] args) {
        String a = "a";
        String string = a.substring(0);
        System.out.println(string);
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("a", "B");
        System.out.println(map.get("a"));
    }
}
