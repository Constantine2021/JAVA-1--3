package Laba3;

import java.util.Hashtable;
import java.util.ArrayList;

public class QuadrilateralHashtable {
    Hashtable<QuadrilateralType, ArrayList<Quadrilateral>> hashtable;

    enum QuadrilateralType {
        Arbitary,
        Square,
        Rectangle,
    }

    public QuadrilateralHashtable(){
        hashtable = new Hashtable<QuadrilateralType, ArrayList<Quadrilateral>>();
    }

    public QuadrilateralHashtable(Quadrilateral...quadrilaterals){
        hashtable = new Hashtable<QuadrilateralType, ArrayList<Quadrilateral>>();
        ArrayList<Quadrilateral> arbitaries = new ArrayList<Quadrilateral>();
        ArrayList<Quadrilateral> squares = new ArrayList<Quadrilateral>();
        ArrayList<Quadrilateral> rectangles = new ArrayList<Quadrilateral>();

        for (Quadrilateral quadrilateral: quadrilaterals){
            if (quadrilateral.isRectangle()){
                if (quadrilateral.isSquare()){
                    squares.add(quadrilateral);
                }
                else{
                    rectangles.add(quadrilateral);
                }
            }
            else{
                arbitaries.add(quadrilateral);
            }
        }

        hashtable.put(QuadrilateralType.Arbitary, arbitaries);
        hashtable.put(QuadrilateralType.Square, squares);
        hashtable.put(QuadrilateralType.Rectangle, rectangles);
    }

    public float findMaxArea(QuadrilateralType type){
        float max = 0f;

        ArrayList<Quadrilateral> arrayList = hashtable.get(type);
        for (Quadrilateral quadrilateral: arrayList){
            float instanceArea = quadrilateral.calculateArea();
            if (max < instanceArea){
                max = instanceArea;
            }
        }
        return max;
    }

    public float findMaxPerimeter(QuadrilateralType type){
        float max = 0f;

        ArrayList<Quadrilateral> arrayList = hashtable.get(type);
        for (Quadrilateral quadrilateral: arrayList){
            float instanceArea = quadrilateral.calculatePerimeter();
            if (max < instanceArea){
                max = instanceArea;
            }
        }
        return max;
    }

    public float findMinArea(QuadrilateralType type){
        ArrayList<Quadrilateral> arrayList = hashtable.get(type);
        float min = arrayList.get(0).calculateArea();

        for (Quadrilateral quadrilateral: arrayList){
            float instanceArea = quadrilateral.calculateArea();
            if (min > instanceArea){
                min = instanceArea;
            }
        }
        return min;
    }

    public float findMinPerimeter(QuadrilateralType type){
        ArrayList<Quadrilateral> arrayList = hashtable.get(type);
        float min = arrayList.get(0).calculatePerimeter();

        for (Quadrilateral quadrilateral: arrayList){
            float instanceArea = quadrilateral.calculatePerimeter();
            if (min > instanceArea){
                min = instanceArea;
            }
        }
        return min;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("");
        for (QuadrilateralType key: hashtable.keySet()){
            s.append(key).append(": ").append(hashtable.get(key).size()).append("\n");
            s.append("--------\n");
            for (Quadrilateral quadrilateral: hashtable.get(key)){
                s.append("Area: ").append(quadrilateral.calculateArea()).append(" ")
                        .append("Perimeter: ").append(quadrilateral.calculatePerimeter()).append("\n");
            }
            s.append("--------\n");
        }

        return s.toString();
    }
}
