package nhn.test.Escape.re.structure;

import java.util.LinkedList;
import java.util.List;

public class WallNode implements Comparable{
    boolean visit;
    WallNode parent;
    List<WallNode> children;
    private int num;
    private int x;
    private int y;
    private int r;

    public WallNode(int num, int x, int y, int r){
        this.num = num;
        this.x = x;
        this.y = y;
        this.r = r;
        children = new LinkedList<>();
    }

    public int getNum() {
        return num;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
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