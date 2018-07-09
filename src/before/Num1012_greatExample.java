package before;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Num1012_greatExample {

    private static void setFalse(boolean[][] arr, int x, int y) {
        if(x<0 || y<0 || x>=arr[0].length || y>=arr.length || !arr[y][x]) return;
        arr[y][x] = false;
        setFalse(arr, x-1, y);
        setFalse(arr, x+1, y);
        setFalse(arr, x, y-1);
        setFalse(arr, x, y+1);
    }

    private static int countBugNeeded(boolean[][] unsafeCabbage) {
        int count = 0;
        for(int y=0; y<unsafeCabbage.length; y++) {
            for(int x=0; x<unsafeCabbage[0].length; x++) {
                if(unsafeCabbage[y][x]) {
                    setFalse(unsafeCabbage, x, y);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        In.init();
        int T = In.nextInt();
        for(int main=0; main<T; main++) {
            int M = In.nextInt();
            int N = In.nextInt();
            int K = In.nextInt();

            boolean[][] unsafeCabbage = new boolean[M][N];
            for(int i=0; i<K; i++)
                unsafeCabbage[In.nextInt()][In.nextInt()] = true;
            System.out.println(countBugNeeded(unsafeCabbage));
        }
    }

    static class In {
        private static BufferedReader in;
        private static StringTokenizer tok;

        static void init() {
            in = new BufferedReader(new InputStreamReader(System.in));
            tok = new StringTokenizer("");
        }

        static String next() {
            while(!tok.hasMoreTokens()) {
                try {
                    tok = new StringTokenizer(in.readLine());
                } catch (IOException e) {}
            }

            return tok.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
