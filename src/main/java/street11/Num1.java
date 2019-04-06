package street11;

import java.util.LinkedList;

class Num1 {
    public int solution(int[] A) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(A[0]);
        int index = 0;
        Integer node;
        while((node = list.get(index++)) != -1){
            list.addLast(A[node]);
        }
        return list.size();
    }
}
