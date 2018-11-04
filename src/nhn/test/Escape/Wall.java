package nhn.test.Escape;

public class Wall{
    private int num;
    private int x;
    private int y;
    private int halfLength;
    
    public Wall(int num, int x, int y, int halfLength){
        this.num = num;
        this.x = x;
        this.y = y;
        this.halfLength = halfLength;
    }
    
    public int getNum(){
        return num;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getHalfLength(){
        return halfLength;
    }
}