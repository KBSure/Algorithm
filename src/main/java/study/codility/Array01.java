package study.codility;

import java.util.HashMap;
import java.util.Map;

public class Array01 {

    public static void main(String[] args) {

    }
    static class Solution {
        Map<Integer, Boolean> map = new HashMap<>();
        public int solution(int[] A) {
            for(int i = 0; i < A.length; i++){
                Boolean isEven;
                if((isEven = map.get(A[i])) != null){
                    map.replace(A[i], !isEven);
                }else{
                    map.put(A[i], false);
                }
            }
            for(Map.Entry <Integer, Boolean> entry : map.entrySet()){
                if(!entry.getValue()) return entry.getKey();
            }
            return 0;
        }
    }
}
