package study.acmicpc.review; // 포도주 시식
// X X에도 재귀호출 하는 것으로 삼았음
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num2156 {
    private static int n;
    private static int[] arr;
    private static int[][][] cache;
    public static void main(String[] args) throws IOException {
        init();
        int answer = recursive(-1, false, false); // k는 인덱스
        System.out.println(answer);
    }

    private static int recursive(int k, boolean before, boolean current) { // sum을 인자로 계속 갱신해가다가 n번째 호출했을 때마다 max와 비교해서 max를 결정한다.
        if(k == n-1) return current ? arr[k] : 0;
        if(k >= 1 && cache[before?1:0][current?1:0][k] != -1) return cache[before?1:0][current?1:0][k];
        int temp1 = -1;
        int temp2 = -1;
        if(k < 1 || !(before && current) ){ //  O O 안됨
            temp1 = recursive(k+1, current, true);
        }
        if(k < 1 || !(!before && !current) ){
            temp2 = recursive(k+1, current, false);
        }
        int tempMax = Math.max(temp1, temp2);
        if(k == -1) return tempMax;
        return cache[before?1:0][current?1:0][k] = current ? tempMax + arr[k] : tempMax;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[10001];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        cache = new int[2][2][10001];
        for(int i = 0; i < 2; i++){
            cache[i] = new int[2][10001];
            for(int j = 0; j < 2; j++){
                cache[i][j] = new int[n];
                Arrays.fill(cache[i][j], -1);
            }
        }
    }
}
