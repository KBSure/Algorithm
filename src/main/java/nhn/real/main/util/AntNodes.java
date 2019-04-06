package nhn.real.main.util;

import nhn.real.main.structure.Answer;
import nhn.real.main.structure.AntNode;

public class AntNodes {
    public static void traversal(boolean[] visited, Answer answer, AntNode startNode, AntNode hereNode, int sum){
        // 다른 leaf에 도착
        visited[hereNode.getNum()] = true;
        if(hereNode.isLeaf() && hereNode != startNode){
            // 정답 갱신
            if(answer.getDistance() < sum){
                answer.setDistance(sum);
                int startNodeNum = startNode.getNum();
                int endNodeNum = hereNode.getNum();
                if(startNodeNum > endNodeNum){
                    answer.setStartNum(endNodeNum);
                    answer.setEndNum(startNodeNum);
                }else{
                    answer.setStartNum(startNodeNum);
                    answer.setEndNum(endNodeNum);
                }
            }
            return;
        }

        // parent로
        // root가 아니라면 부모쪽으로
        if(hereNode.hasParent() && !visited[hereNode.getParent().getNum()]) {
            traversal(visited, answer, startNode, hereNode.getParent(), sum + hereNode.getDistance());
        }
        // child로
        for(AntNode child : hereNode.getChildren()){
            if(!visited[child.getNum()]) {
                traversal(visited, answer, startNode, child, sum + child.getDistance());
            }
        }
    }

    public static AntNode findRoot(int nodeCount, AntNode start){
        boolean[] visited = new boolean[nodeCount+1];
        AntNode root = start;
        while(root.hasParent()){
            root = root.getParent();
            if(visited[root.getNum()]) return null;
            visited[root.getNum()] = true;
        }
        return root;
    }
}
