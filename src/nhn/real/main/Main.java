package nhn.real.main;

import nhn.real.main.structure.Answer;
import nhn.real.main.structure.AntNode;
import nhn.real.main.util.AntNodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static int antRoomCount;
    private static Map<Integer, AntNode> antNodeMap;
    private static Answer answer;
    private static List<AntNode> leafList;
    public static void main(String[] args) throws IOException {
        if(!init()){ // cycle이면
            System.out.println(-1);
            return;
        }

        //순회
        for(int i = 1; i <= antNodeMap.size(); i++){
            AntNode leaf = antNodeMap.get(i);
            if(leaf.isLeaf()){
                boolean[] visited = new boolean[antRoomCount+1];
                AntNodes.traversal(antNodeMap, visited, answer, leaf, leaf, 0);
            }
        }

        System.out.println(answer.getDistance());
        System.out.println(answer.getStartNum());
        System.out.println(answer.getEndNum());
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

            if(child.hasParent()){
                return false;
            }
            // 관계 맺어주기 (트리화)
            child.setParent(parent);
            child.setDistance(distance);
            parent.addChild(child);

            // root 구해놓기 (아직)
        }

        answer = new Answer(0, 0, 0);
        return true;
    }
}
