package nhn.test.Escape.re;

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
        for(int i = 0; i < wallList.size() - 1; i++){
            WallNode child = wallList.get(i);
            for(int j = i+1; j < wallList.size(); j++){
                // 부모 자식 관계 지어주기
                WallNode tempParent = wallList.get(j);
                if(isParent(child, tempParent)){ // 조건 만족하면 Node 연결
                    child.setParent(tempParent);
                    tempParent.getChildren().add(child);
                    break;
                }
            }
        }
        // 트리 완성 되었으면 순회하기
        if(startWallNum == endWallNum){ //시작과 끝이 같으면
            System.out.println(startWallNum);
            return;
        }
        traversal(startWall); //순회
        if(answerList.size() == 0){
            System.out.println(-1);
            return;
        }

        answerList.addFirst(startWall.num);

        for(int i = 0; i < answerList.size(); i++){
            if(i == 0){
                System.out.print(answerList.get(i));
                continue;
            }
            System.out.print(" " + answerList.get(i));
        }
    }

    private static boolean traversal(WallNode here){
        //방향은 자식, 부모 순
        //end에 도착하면 끝
        here.setVisit(true);
        if(here == endWall){
            return true;
        }
        //자식쪽
        List<WallNode> children = here.getChildren();
        for(WallNode child : children){
            if(!child.isVisit() && traversal(child)){
                answerList.addFirst(child.num);
                return true;
            }
        }
        //부모쪽
        WallNode parent = here.getParent();
        if(!parent.isVisit() && traversal(parent)){
            answerList.addFirst(parent.num);
            return true;
        }

        if(here != startWall){
            return false;
        }

        return true;
    }

    private static boolean isParent(WallNode child, WallNode tempParent){
        // r2 - r1 > 거리 : true
        int subtractR = tempParent.r - child.r;
        if(subtractR == 0) return false; //겹치지 않으므로 반지름이 같다는 건 부모자식이 아니다.
        int distance = (int)Math.sqrt(Math.pow(child.x - tempParent.x, 2) + Math.pow(child.y - tempParent.y, 2));
        return subtractR > distance;
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

    private static class WallNode implements Comparable{
        boolean visit;
        WallNode parent;
        List<WallNode> children;
        private int num;
        private int x;
        private int y;
        private int r;

        WallNode(int num, int x, int y, int r){
            this.num = num;
            this.x = x;
            this.y = y;
            this.r = r;
            children = new LinkedList<>();
        }

        public boolean isVisit() {
            return visit;
        }

        public void setVisit(boolean visit) {
            this.visit = visit;
        }

        public WallNode getParent() {
            return parent;
        }

        public void setParent(WallNode parent) {
            this.parent = parent;
        }

        public List<WallNode> getChildren() {
            return children;
        }

        public void setChildren(List<WallNode> children) {
            this.children = children;
        }

        @Override
        public int compareTo(Object o) {
            // 반지름을 기준으로 sorting할거임
            return this.r - ((WallNode)o).r;
        }
    }
}
