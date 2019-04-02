package study.programmers; // 모의고사

import java.util.List;
import java.util.ArrayList;
public class Num42840 {
    public int[] solution(int[] answers) {
        // 패턴 배열로 저장 후 반복문 돌면서 채점
        List<int[]> list = new ArrayList<>();
        int[] answerArray = new int[3];
        list.add(new int[]{1, 2, 3, 4, 5});
        list.add(new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        list.add(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        for(int i = 0; i < list.size(); i++){
            int[] pattern = list.get(i);
            int index = 0;
            for(int j = 0; j < answers.length; j++){
                if(index == pattern.length) index = 0;
                if(answers[j] == pattern[index++]) answerArray[i]++;
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < answerArray.length; i++){
            maxValue = Math.max(maxValue, answerArray[i]);
        }
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < answerArray.length; i++){
            if(maxValue == answerArray[i]){
                answerList.add(i+1);
            }
        }
        int[] ret = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            ret[i] = answerList.get(i);
        }
        return ret;
    }
}
