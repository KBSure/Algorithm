package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0보다 내려가는 경우 신경쓰기
public class Num1107re {
    private static int N; //이동할 채널
    private static int M; //고장난 버튼 수
    private static boolean[] broken;
    private static final int DEFAULT = 100;
    public static void main(String[] args) throws IOException {
        init();
        //N - default를 최소 수로 일단 넣고
        int btnMin = Math.abs(N - DEFAULT);
        //버튼 누르고 +- 계산
//        for(int num = 0; num <= 10000000; num++){
        if(N > DEFAULT) {
            for (int num = N - btnMin + countPushNum(N + btnMin); num < N + btnMin - countPushNum(num + btnMin); num++) {
                //pushCh 누를 수 있는지(broken으로 점검)[if문], 있다면
                //pushCh 누를 때 필요한 버튼 수[메서드로 반환] + N까지 updown 수
                int countPushNum = countPushNum(num);
                if (countPushNum > 0) { //한 번에 눌렀으면???
                    int countPushToAim = countPushNum + Math.abs(N - num);
                    if (btnMin > countPushToAim) btnMin = countPushToAim;
                }
            }
        }else{
            for (int num = 0; num < DEFAULT - countPushNum(N); num++){
                int countPushNum = countPushNum(num);
                if (countPushNum > 0) { //한 번에 눌렀으면???
                    int countPushToAim = countPushNum + Math.abs(N - num);
                    if (btnMin > countPushToAim) btnMin = countPushToAim;
                }
            }
        }
        System.out.println(btnMin);
    }

    private static int countPushNum(int pushNum){
        //broken이 없으면?
        int count = 0;
        if(pushNum == 0){
            if(!broken[0]) return 1;
        }
        while(pushNum > 0) {
            int intAt = pushNum % 10;
                if(broken[intAt]) return 0;
            count++;
            pushNum /= 10;
        }

        //count + channel 수
        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];
        if(M == 0) return;
        String[] split = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            broken[Integer.parseInt(split[i])] = true;
        }
    }
}
