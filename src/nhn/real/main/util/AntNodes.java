package nhn.real.main.util;

import nhn.real.main.structure.Answer;
import nhn.real.main.structure.AntNode;

import java.util.Map;

public class AntNodes {
    public static void traversal(Map<Integer, AntNode> antNodeMap, boolean[] visited, Answer answer, AntNode startNode, AntNode hereNode, int sum){
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
            traversal(antNodeMap, visited, answer, startNode, hereNode.getParent(), sum + hereNode.getDistance());
        }
        // child로
        for(AntNode child : hereNode.getChildren()){
            if(!visited[child.getNum()]) {
                traversal(antNodeMap, visited, answer, startNode, child, sum + child.getDistance());
            }
        }
    }
}
