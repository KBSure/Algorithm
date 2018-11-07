package nhn.test.Escape.re;

import nhn.test.Escape.re.structure.WallNode;
import nhn.test.Escape.re.util.WallNodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int wallCount;
    private static List<WallNode> wallList;
    private static int startWallNum;
    private static int endWallNum;
    private static WallNode startWall;
    private static WallNode endWall;
    private static LinkedList<Integer> answerList;

    public static void main(String[] args) throws IOException {
        init();
        WallNodes.makeTree(wallList);
        // 트리 완성 되었으면 순회하기
        printAnswer();
    }

    private static void printAnswer(){
        if(startWallNum == endWallNum){ //시작과 끝이 같으면
            System.out.println(startWallNum);
            return;
        }
        WallNodes.traversal(startWall, startWall, endWall, answerList); //순회
        if(answerList.size() == 0){
            System.out.println(-1);
            return;
        }

        answerList.addFirst(startWall.getNum());

        for(int i = 0; i < answerList.size(); i++){
            if(i == 0){
                System.out.print(answerList.get(i));
                continue;
            }
            System.out.print(" " + answerList.get(i));
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wallCount = Integer.parseInt(br.readLine());
        wallList = new ArrayList<>();
        WallNode root = new WallNode(0, 5000, 5000, 15000);
        wallList.add(root);
        for(int i = 0; i < wallCount; i++){ // wallList에 넣기
            String[] split = br.readLine().split(" ");
            int num = Integer.parseInt(split[0]);
            int x = Integer.parseInt(split[1]);
            int y = Integer.parseInt(split[2]);
            int r = Integer.parseInt(split[3]);
            WallNode node = new WallNode(num, x, y, r);
            wallList.add(node);
        }
        String[] split = br.readLine().split(" ");
        startWallNum = Integer.parseInt(split[0]);
        endWallNum = Integer.parseInt(split[1]);

        startWall = wallList.get(startWallNum);
        endWall = wallList.get(endWallNum);

        Collections.sort(wallList); //sorting(반지름 기준 오름차순)

        answerList = new LinkedList<>();
    }
}
