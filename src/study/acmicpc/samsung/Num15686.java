package study.acmicpc.samsung;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num15686 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static List<Node> chickenList;
    private static List<Node> houseList;
    private static boolean[] checkChicken;
    private static Map<Key, Integer> cache;

    public static void main(String[] args) throws IOException {
        init();
        int pickCount = chickenList.size() - M;
        System.out.println(pick(pickCount));
    }

    private static int pick(int c) {
        //pick한 것으로 치킨 거리를 구한다.
        Key key;
        if (cache.containsKey((key = new Key(checkChicken)))) {
            return cache.get(key);
        }
        int ret = Integer.MAX_VALUE;
        if (c == 0) {
            return calcDistance();
        }
        for (int i = 0; i < checkChicken.length; i++) {
            if (checkChicken[i]) {
                checkChicken[i] = false;
                ret = Math.min(pick(c - 1), ret);
                key = new Key(checkChicken);
                cache.put(key, ret);
                checkChicken[i] = true;
            }
        }
        return ret;
    }

    private static int calcDistance() {
        //chickenList
        //집 기준으로 가장 가까운 치킨집 길이의 합
        int ret = 0;
        for (int i = 0; i < houseList.size(); i++) {
            int houseI = houseList.get(i).i;
            int houseJ = houseList.get(i).j;
            int tempDistance = 2 * N;
            for (int j = 0; j < chickenList.size(); j++) {
                if (checkChicken[j]) {
                    int chickenI = chickenList.get(j).i;
                    int chickenJ = chickenList.get(j).j;
                    tempDistance = Math.min(tempDistance, Math.abs(houseI - chickenI) + Math.abs(houseJ - chickenJ));
                }
            }
            ret += tempDistance;
        }
        return ret;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][N]; // 문제는 1,1부터 시작
        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] split2 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split2[j]);
                if (map[i][j] == 1) {
                    houseList.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }

        checkChicken = new boolean[chickenList.size()];
        for (int i = 0; i < checkChicken.length; i++) {
            checkChicken[i] = true;
        }

        cache = new HashMap<>();
    }

    private static class Node {
        private int i;
        private int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static class Key {
        private boolean[] checkChicken;
        private int size;

        Key(boolean[] checkChicken) {
            this.checkChicken = checkChicken;
            this.size = checkChicken.length;
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }

        @Override
        public int hashCode() {
            int result = 17; // any prime number
            for (int i = 0; i < size; i++) {
                result = 31 * result + Boolean.valueOf(checkChicken[i]).hashCode();
            }
            return result;
        }


    }

}
