package nhn.real.main.structure;

import java.util.LinkedList;
import java.util.List;

public class AntNode {
    private int num;
    private AntNode parent;
    private List<AntNode> children;
    private int distance; // 부모와의 거리

    public boolean isLeaf(){
        return children.isEmpty();
    }


    public AntNode(int num){
        this.num = num;
        children = new LinkedList<>();
    }

    public boolean hasParent(){
        return parent != null;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public AntNode getParent() {
        return parent;
    }

    public void setParent(AntNode parent) {
        this.parent = parent;
    }

    public List<AntNode> getChildren() {
        return children;
    }

    public void addChild(AntNode child){
        children.add(child);
    }
}
