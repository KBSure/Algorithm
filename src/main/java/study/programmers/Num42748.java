package study.programmers; // K번째수

import java.util.Arrays;

public class Num42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] ints = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(ints);
            answer[i] = ints[commands[i][2] - 1];
        }
        return answer;
    }
}
