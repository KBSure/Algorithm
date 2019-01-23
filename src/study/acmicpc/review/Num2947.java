package study.acmicpc.review;
//나무조각
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2947 {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        init();
        boolean isSwitch = false;
        do{
            isSwitch = false;
            for(int i = 0; i < arr.length-1; i++){
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                    isSwitch = true;
                    printArr(arr);
                }
            }
        }
        while(isSwitch);

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                System.out.print(arr[0]);
                continue;
            }
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        arr = new int[5];
        for(int i = 0; i < 5; i++){
            arr[i] = Integer.parseInt(split[i]);
        }
    }
}
