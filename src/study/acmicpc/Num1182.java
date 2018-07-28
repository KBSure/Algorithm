package study.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1182 {
    private static int N;
    private static int S;
    private static int[] integerArray;
    private static LinkedList<Integer> indexList;
    private static int count;

    public static void main(String[] args) throws IOException {
        init();
        findSubSet(0);
        System.out.println(count);
    }

    private static void findSubSet(int currentSum){
        //인덱스 리스트 꺼내면서 합을 구한다. 합이 조건에 맞으면 count++
        if(indexList.size() != 0 && currentSum == S){
            count++;
        }
        //integerArray 끝까지 돌았는데 없었으면 return;
        int lastIndex = -1;
        if(indexList.size() != 0) {
            lastIndex = indexList.peekLast();
            if(lastIndex == N-1) return;
        }

        //인데스 리스트 마지막 걸 꺼내서 그 다음 인덱스를 기록한 뒤, for문 돌리면서 재귀 호출
        for(int i = lastIndex+1; i < N; i++){
            indexList.addLast(i);
            findSubSet(currentSum + integerArray[i]);
            indexList.removeLast();
        }


    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLineSplit = br.readLine().split(" ");
        N = Integer.parseInt(firstLineSplit[0]);
        S = Integer.parseInt(firstLineSplit[1]);
        integerArray = new int[N];

        String[] integerSplit = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            integerArray[i] = Integer.parseInt(integerSplit[i]);
        }

        indexList = new LinkedList<>();
//        indexArray = new boolean[N];
    }
}
