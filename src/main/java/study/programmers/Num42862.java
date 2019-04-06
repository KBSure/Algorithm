package study.programmers; //체육복

import java.util.Arrays;

public class Num42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1. 여벌이 있어도 잃어버린 사람은 빌려줄 수 없다. 빌려줄 수 있는 사람 추려내기
        // 2. 빌려줘야 할 사람이 두 명인 경우, 어떤 사람을 빌려줘야 더 많이 빌려줄 수 있는지
        // 잃어버린 사람이 여벌 있는 경우 신경 쓰기
        int ret = 0;
        int[] clothes = new int[n+1];
        Arrays.fill(clothes, 1);
        clothes[0] = Integer.MIN_VALUE;
        for(int i = 0; i < lost.length; i++){
            clothes[lost[i]]--;
        }
        for(int i = 0; i < reserve.length; i++){
            clothes[reserve[i]]++;
        }

        // 0이라면 그 뒤에서 빌린다.
        // 2이라면 그 뒤에 빌려준다.
        for(int i = 1; i < clothes.length - 1; i++){
            if(clothes[i] == 0){
                if(clothes[i+1] == 2){
                    clothes[i+1]--;
                    clothes[i]++;
                }
            }else if(clothes[i] == 2){
                if(clothes[i+1] == 0){
                    clothes[i+1]++;
                    clothes[i]--;
                }
            }
        }

        for(int i = 1; i < clothes.length; i++){
            if(clothes[i] >= 1) ret++;
        }
        return ret;
    }
}
