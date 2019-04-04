package study.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num42577 {
    public boolean solution(String[] phone_book) {
        List<PhoneNumber> list = new ArrayList<>();
        for(int i = 0; i < phone_book.length; i++){
            list.add(new PhoneNumber(phone_book[i]));
        }
        Collections.sort(list);
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(j).number.startsWith(list.get(i).number) ){
                    return false;
                }
            }
        }
        return true;
    }

    class PhoneNumber implements Comparable<PhoneNumber> {
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
