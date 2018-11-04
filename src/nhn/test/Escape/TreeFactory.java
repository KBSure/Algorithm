package nhn.test.Escape;

import java.util.List;

public class TreeFactory {
    TreeNode<Integer> root;
    TreeNode<Integer> makeTree(List<Wall> wallList){
        root = new TreeNode<>(0);
        // 거리 계산과 반지름 비교로 관계 정하기
        // for 돌면서 비교
          // 반지름의 합이 거리보다 크면 포함 관계이다.
          // 이때, 반지름이 큰 쪽이 parent, 작은 쪽이 child
          // parent가 이미 child가 있다면 child 추가
          // child가 이미 parent가 있다면 child의 기존 parent와 새로운 parent 비교
            // 기존 parent가 새 parent보다 크다면 그 사이에 새 parent 삽입
            // 새 parent가 더 크다면 기존 parent의 parent와 비교.. 이런 식으로 반복
        
        for(int i = 0; i < wallList.size()-1; i++){
                Wall wall1 = wallList.get(i);
            for(int j = i+1; j < wallList.size(); j++){
                Wall wall2 = wallList.get(j);
                if(isSurround(wall1, wall2)){
                    if(wall1.getHalfLength() > wall2.getHalfLength()){
                        addNodeAsHierachy(wall1.getNum(), wall2.getNum());
                    }else{
                        addNodeAsHierachy(wall2.getNum(), wall1.getNum());
                    }
                }
            }
        }
        return null;
    }
    
    private void addNodeAsHierachy(int parent, int child){
        while(true){
//            if(root.searchNode(child).getParent().getData(). > parent
        }
    }
    
    private boolean isSurround(Wall wall1, Wall wall2){
        int powInt = (int)Math.pow(wall1.getX() - wall2.getX(), 2) + (int)Math.pow(wall1.getY() - wall2.getY(), 2);
        
        if(powInt < Math.pow(wall1.getHalfLength() + wall2.getHalfLength(), 2)){
            return true;
        }
        return false;
    }
}
