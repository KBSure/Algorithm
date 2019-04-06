package cacao.review;

import java.util.Arrays;

public class Num2 {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] solution(int N, int[] stages) {
            // stages : 각 user 마다 현재 있는 스테이지 레벨 기록
            // N : 스테이지 개수
            int userCount = stages.length; // user 수
            // 실패율 0 : 모두 통과한 경우. 아무도 시도 하지 않은 것은 실패율 0이 아니다.

            double[] failureLates = new double[N+1]; // stage마다 실패율 저장
            failureLates[0] = Double.MIN_VALUE;
            int[] tryingUserCountbyStage = new int[N+2]; // stage 마다 도전중인 user 수 //1~N+1

            int[] answer = new int[N];


            for(int i = 0; i < stages.length; i++){
                tryingUserCountbyStage[stages[i]]++;
            }

            int tryCount = userCount;
            for(int i = 0; i < N; i++){
                if(tryCount == 0) failureLates[i] = 0.0;
                failureLates[i] = (double)tryingUserCountbyStage[i] / (double)tryCount;
                tryCount -= tryingUserCountbyStage[i];
            }
            double[] sortFailureLates = Arrays.copyOf(failureLates, failureLates.length);
            Arrays.sort(sortFailureLates);
            int answerIdx = 0;
            int j = 1;
            for(int i = sortFailureLates.length - 1; i >= 1; i--){
                for(; j < failureLates.length; j++){
                    if(sortFailureLates[i] == failureLates[j]){
                        answer[answerIdx++] = j;
                        break;
                    }
                }
                if(sortFailureLates[i] == sortFailureLates[i-1]){
                    j = j + 1;
                }else{
                    j = 1;
                }
            }
            // 정렬

            // 정렬하고, 순서대로 찾아서

            return answer;
        }
    }
}
