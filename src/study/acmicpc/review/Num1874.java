package study.acmicpc.review; //스택수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Num1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> stack = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        boolean[] answerList = new boolean[n*2];  //true가 push false가 pop
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int j = 0;
        int k = 0;
        for(int i = 0; i < n; i++){ //arr[i]
            if(stack.isEmpty() || stack.peekLast() != arr[i] ){
                if(j == n) break;
                stack.addLast(++j);
                answerList[k++] = true;
                --i;
            }else{
                stack.pollLast();
                answerList[k++] = false;
            }
        }

        if(!stack.isEmpty()){
            System.out.println("NO");
            return;
        }

        for(int i = 0; i < answerList.length; i++){
            System.out.println(answerList[i] ? "+" : "-");
        }


        //for문 끝났는데 비어있으면 안됨
    }
}
