package nhn.test.Escape;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static int wallCount;
    private static List<Wall> wallList;
    public static void main(String[] args) throws Exception {
        init();
        TreeNode<Integer> root = new TreeNode<>(0);
    }
    
    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wallCount = Integer.parseInt(br.readLine());
        wallList = new ArrayList<>();
        for(int i = 0; i < wallCount; i++){
            String[] split = br.readLine().split(" ");
            int num = Integer.parseInt(split[0]);
            int x = Integer.parseInt(split[1]);
            int y = Integer.parseInt(split[2]);
            int halfLength = Integer.parseInt(split[3]);
            Wall wall = new Wall(num, x, y, halfLength);
            wallList.add(wall);
        }
    }

}
