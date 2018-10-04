package nhn.real;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Num1 {
    private static LinkedList<Integer> cardList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        cardList = new LinkedList<>();
        for(int i = 1; i <= C; i++){
            cardList.addLast(i);
        }
        for(int i = 0; i < P; i++){
            int N = Integer.parseInt(br.readLine());
            mix(C, N);
        }

        for(int i = 0; i < 5; i++){
            System.out.println(cardList.get(i));
        }
    }

    private static void mix(int C, int N){
        //checkIndex가 N*2보다 작으면
        int checkIndex = C-1;
        while(checkIndex > N*2){ //이때까지 섞는다.
            for(int i = 0; i < N; i++){
                cardList.add(checkIndex - N, cardList.pollFirst());
            }
            checkIndex -= N*2;
        }
    }
}
