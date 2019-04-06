package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num14501 {
    public static void main(String[] args) throws IOException {
        //입력 받기
        //index + pi < index + 1 로 t(i+1) 넣어서 재귀호출 할 수 있는지
        //maxP 비교해서 계속 리턴

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Work[] workArray = new Work[N+1];
        for(int i = 1; i <= N; i++){
            String[] workSplit = br.readLine().split(" ");
            workArray[i] = new Work(Integer.parseInt(workSplit[0]), Integer.parseInt(workSplit[1]));
        }
        System.out.println(countMaxPrice(workArray, 1, N, 0));

    }

    static int countMaxPrice(final Work[] work, int today, final int maxWorkDay, int currentPrice){
        //기저1 : N일 넘었으면
        //return currentPrice
        if(today > maxWorkDay){
            return currentPrice;
        }

        //지금 현재 day + work[day].term
        //if(day + work[day].term <= N + 1) //퇴직 전까지 일할 수 있는지 && 지금 일할 수 있는지
        int candAsWorkToday = -1;
        if(today + work[today].term <= maxWorkDay+1) {
            candAsWorkToday = countMaxPrice(work, today + work[today].term, maxWorkDay, currentPrice + work[today].price);
        }
        int candAsNotWorkToday = countMaxPrice(work, today+1, maxWorkDay, currentPrice);
        return Math.max(candAsWorkToday,candAsNotWorkToday);
    }

    static class Work{
        int term;
        int price;
        Work(int term, int price){
            this.term = term;
            this.price = price;
        }
    }
}