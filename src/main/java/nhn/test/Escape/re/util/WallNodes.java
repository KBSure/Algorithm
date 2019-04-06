package nhn.test.Escape.re.util;

import nhn.test.Escape.re.structure.WallNode;

import java.util.LinkedList;
import java.util.List;

public class WallNodes {
    public static void makeTree(List<WallNode> wallList){
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
    }

    public static boolean traversal(WallNode here, WallNode startWall, WallNode endWall, LinkedList<Integer> answerList){
        //방향은 자식, 부모 순
        //end에 도착하면 끝
        here.setVisit(true);
        if(here == endWall){
            return true;
        }
        //자식쪽
        List<WallNode> children = here.getChildren();
        for(WallNode child : children){
            if(!child.isVisit() && traversal(child, startWall, endWall, answerList)){
                answerList.addFirst(child.getNum());
                return true;
            }
        }
        //부모쪽
        WallNode parent = here.getParent();
        if(parent != null && !parent.isVisit() && traversal(parent, startWall, endWall, answerList)){
            answerList.addFirst(parent.getNum());
            return true;
        }

        if(here != startWall){
            return false;
        }

        return true;
    }

    private static boolean isParent(WallNode child, WallNode tempParent){
        // r2 - r1 > 거리 : true
        int subtractR = tempParent.getR() - child.getR();
        if(subtractR == 0) return false; //겹치지 않으므로 반지름이 같다는 건 부모자식이 아니다.
        int distance = (int)Math.sqrt(Math.pow(child.getX() - tempParent.getX(), 2) + Math.pow(child.getY() - tempParent.getY(), 2));
        return subtractR > distance;
    }
}
