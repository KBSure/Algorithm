package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer> buttonList = new ArrayList<>();

        String[] brokenButtonsStringArray = br.readLine().split(" ");
        for(int i = 0; i <= 9; i++){
            buttonList.add(i);
        }
        for(int i = 0; i < M; i++){
            buttonList.remove((Integer)Integer.parseInt(brokenButtonsStringArray[i]));
        }

        System.out.println(findButtonCount(buttonList, N));
    }

    static int findButtonCount(List<Integer> buttonList, int N){
        //현재 숫자를 리모컨으로 누를 수 있다면

        int upNum = N;
        int downNum = N;
        int upDownCount = 0;

        if(N >=98 && N <=103) return specialAnswer(buttonList, N);
        while(true){
            upDownCount++;
            if(isMakeNum(buttonList, ++upNum)){
                return upDownCount + countPushButton(upNum);
            }
            if(isMakeNum(buttonList, --downNum)){
                return upDownCount + countPushButton(downNum);
            }
        }
    }

    private static int specialAnswer(List<Integer> buttonList, int N) {
        if(N == 100) return 0;
        int upDownCount = 0;
        int upNum = N;
        int downNum = N;
        while(true){
            upDownCount++;
            if(100 == ++upNum) return upDownCount;
            if(100 == --downNum) return upDownCount;
        }
    }

    static int countPushButton(int num){
        if(num == 0) return 1;
        int ret = 0;
        while(num != 0){
            num /= 10;
            ret++;
        }
        return ret;
    }

    static boolean isMakeNum(List<Integer> buttonList, int num){
        String[] currentNumberStringArray = Integer.toString(num).split("");
        for(String s : currentNumberStringArray){
            if(!buttonList.contains(Integer.parseInt(s))){ //버튼 포함되어 있으면 계속 for문
                return false;
            }
        }
        return true;
    }
}
