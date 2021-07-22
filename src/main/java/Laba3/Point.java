package Laba3;

public class Point {
    private float x;
    private float y;

    public Point(){
        x = 0f;
        y = 0f;
    }

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public void setX(float value){
        x = value;
    }

    public float getY(){
        return y;
    }

    public void setY(float value){
        y = value;
    }
}
