package nhn.real.main;

import nhn.real.main.structure.Answer;
import nhn.real.main.structure.AntNode;
import nhn.real.main.util.AntNodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int antRoomCount;
    private static Map<Integer, AntNode> antNodeMap;
    private static Answer answer;
    private static AntNode root;
    private static List<AntNode> leafList;
    private static int allDistance;

    public static void main(String[] args) throws IOException {
        if(!init()){ // cycle이면
            System.out.println(-1);
            return;
        }

        findAnswer();

        System.out.println(answer.getDistance());
        System.out.println(answer.getStartNum());
        System.out.println(answer.getEndNum());
    }

    private static void findAnswer(){
        if(leafList.size() == 1){
            AntNode leaf = leafList.get(0);
            if(root.getNum() < leaf.getNum()){
                answer.setStartNum(root.getNum());
                answer.setEndNum(leaf.getNum());
                answer.setDistance(allDistance);
            }else{
                answer.setStartNum(leaf.getNum());
                answer.setEndNum(root.getNum());
                answer.setDistance(allDistance);
            }
            return;
        }
        //순회
        for(AntNode leaf : leafList){
            boolean[] visited = new boolean[antRoomCount+1];
            AntNodes.traversal(visited, answer, leaf, leaf, 0);
        }
    }

    private static boolean init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        antRoomCount = Integer.parseInt(br.readLine());
        antNodeMap = new HashMap<>();
        for(int i = 1; i <= antRoomCount; i++){
            antNodeMap.put(i, new AntNode(i));
        }

        for(int i = 0; i < antRoomCount - 1; i++){
            String[] split = br.readLine().split(" ");
            int parentNum = Integer.parseInt(split[0]);
            int childNum = Integer.parseInt(split[1]);
            int distance = Integer.parseInt(split[2]);

            AntNode parent = antNodeMap.get(parentNum);
            AntNode child = antNodeMap.get(childNum);

            if(child.hasParent()){ // parent가 이미 있는 child는 cycle
                return false;
            }

            // 관계 맺어주기 (트리화)
            child.setParent(parent);
            child.setDistance(distance);
            parent.addChild(child);
        }

        leafList = new ArrayList<>();
        for(int i = 1; i <= antRoomCount; i++) {
            AntNode node = antNodeMap.get(i);
            if(node.isLeaf()){
                leafList.add(node);
            }
            if(!node.hasParent()) root = node;
            allDistance += node.getDistance();
        }

        //root가 없으면 cycle
        if(root == null) return false;

        answer = new Answer(0, 0, 0);
        return true;
    }
}
