package nhn.real.main.structure;

public class Answer {
    private int distance;
    private int startNum;
    private int endNum;

    public Answer(int distance, int startNum, int endNum){
        this.distance = distance;
        this.startNum = startNum;
        this.endNum = endNum;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getEndNum() {
        return endNum;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }
}
