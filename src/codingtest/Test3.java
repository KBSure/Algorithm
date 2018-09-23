package codingtest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class StringGroup1{
    List<String> list;

    StringGroup1(String... args){
        list = new ArrayList<>();
        for(String string : args){
            list.add(string);
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        for(int i = 0; i < list.size(); i++) {
            result = 31 * result + list.get(i).hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
public class Test3 {
    public static void main(String[] args) {
        Set<StringGroup1> set = new HashSet<>();
        set.add(new StringGroup1(new String[]{"a", "b"}));
        set.add(new StringGroup1(new String[]{"a", "b"}));

//        Set<String[]> set2 = new HashSet<>();
//        set2.add(new String[]{"a","b"});
//        set2.add(new String[]{"a","b"});

        System.out.println(set.size());
    }
}
