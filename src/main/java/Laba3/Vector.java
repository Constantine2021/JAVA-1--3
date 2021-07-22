package Laba3;

public class Vector {
    private float[] coords;

    public Vector(){
        coords = new float[0];
    }

    public Vector(float...coords){
        this.coords = coords;
    }

    public Vector(float[] from, float[] to){
        if (from.length != to.length){
            throw new ExceptionInInitializerError("Wrong amount of coords");
        }
        else{
            coords = new float[to.length];
            for (int i = 0; i < from.length; i++){
                coords[i] = to[i] - from[i];
            }
        }
    }

    public Vector(Point from, Point to){
        coords = new float[2];
        coords[0] = to.getX() - from.getX();
        coords[1] = to.getY() - from.getY();
    }

    public float[] getCoords() {
        return coords;
    }

    public void setCoords(float[] coords) {
        this.coords = coords;
    }

    public int size(){
        return coords.length;
    }

    public float getCoord(int index){
        return coords[index];
    }

    public float getVectorLength(){
        float length = 0;
        for (float coord: coords){
            length += coord * coord;
        }
        return (float)Math.sqrt(length);
    }
}
