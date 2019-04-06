package nhn.real.technic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowEgg {
    //100층 까지 계란 2개
    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int stage = 0;
//        try {
//            stage = Integer.parseInt(br.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        int answer = throw1(10, 10, 99, 2);
        int answer2 = throw1(15, 15, 89, 2);
        System.out.println(answer);
        System.out.println(answer2);
    }

    private static int throw1(int startStage, int addCount, int answerStage, int eggCount){
        //10층 부터 10층 간격
        int hereStage = startStage;
        int ret = 0;
        ret++;
        while(hereStage < answerStage){ // 안깨지는 중
            if(hereStage + addCount > 100){
                addCount = 100 - hereStage;
            }
            hereStage += addCount;
            ret++;
        }
        //while문 나오면 깨진다.
        eggCount--;
        hereStage = hereStage - addCount + 1;
        ret++;
        while(answerStage != hereStage){
            hereStage++;
            ret++;
        }
        eggCount--;
        return ret;
    }
}
