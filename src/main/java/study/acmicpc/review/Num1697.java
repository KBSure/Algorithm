package study.acmicpc.review;
//숨바꼭질
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//StackOverFlow
public class Num1697 {
    private static int N;
    private static int K;
    private static int[] cache;
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(countTryToFind(N, 0, K));
    }

    private static int countTryToFind(int here, int count, int answer) {
        if(here < 0 || here > 100000) return Integer.MAX_VALUE; // 경계 벗어나지 않게
        if(here == answer) return count; // 정답 찾았다면
        if(cache[here] != -1 && count > cache[here] ) return Integer.MAX_VALUE; // cache에 값이 있고, 그 값이 더 작으면 분기 안한다
        cache[here] = count;
        int min = Integer.MAX_VALUE;
        min = Math.min(min, countTryToFind(here*2, count+1, answer));
        min = Math.min(min, countTryToFind(here+1, count+1, answer));
        min = Math.min(min, countTryToFind(here-1, count+1, answer));
        return min;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        cache = new int[100001];
        Arrays.fill(cache, -1);
    }

}
