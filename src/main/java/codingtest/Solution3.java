package codingtest;

import java.util.*;

class StringGroup{
    List<String> list;

    StringGroup(String... args){
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

public class Solution3 {
    public int solution(String[][] relation) {
        int r = relation.length;
        int c = relation[0].length;
        int num = 0;
        while(num++ >= c){
            Set<String[]> set = new HashSet();
            LinkedList<Integer> columns = new LinkedList<>();
//            isCandidate()
        }

        return 0;
    }

    boolean isCandidate(int r, int c, String[][] relation, LinkedList<Integer> columns, int toPick){
        if(toPick == 0) {
            Set<StringGroup> set = new HashSet<>();
            for (int i = 0; i < columns.size(); i++) {
                String[] strings = new String[columns.size()];
                for (int j = 0; j < r; j++) {
                    strings[i] = relation[j][columns.get(i)];
                }
                set.add(new StringGroup(strings));
            }
            if (set.size() == r) return true;
            else return false;
        }
        for(int next = columns.getLast(); next < c; next++){
            columns.addLast(next);
            isCandidate(r, c, relation, columns, toPick - 1);
            columns.removeLast();
        }
        return true;
    }

}
