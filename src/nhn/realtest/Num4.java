package nhn.realtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num4 {
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N-1; i++){
            for(int j = i+1; j < N; j++){
                if(arr[i] > arr[j]){
                    continue;
                }else{
                    max = Math.max(max, j-i);
                    break;
                }
            }
        }

        for(int i = N-1; i > 0; i--){
            for(int j = i-1; j >= 0; j--){
                if(arr[i] > arr[j]){
                    continue;
                }else{
                    max = Math.max(max, i-j);
                    break;
                }
            }
        }

        System.out.println(max);

    }
}
