package study.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String[] strings = new String[4];
        strings[0] = "123";
        strings[1] = "12345";
        strings[2] = "45667";
        strings[3] = "3424234";
        List<PhoneNumber> list = new ArrayList<>();
        for(int i = 0; i < strings.length; i++){
            list.add(new PhoneNumber(strings[i]));
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).number);
        }


    }

    static class PhoneNumber implements Comparable<PhoneNumber> {
        String number;
        PhoneNumber(String number){
            this.number = number;
        }
        @Override
        public int compareTo(PhoneNumber o) {
            return this.number.length() - o.number.length();
        }
    }
}
