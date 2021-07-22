package Laba3;

public class Quadrilateral {
    private Point[] points;

    public Quadrilateral() {
        points = new Point[0];
    }

    public Quadrilateral(Point...points){
        if (points.length != 4){
            throw new ExceptionInInitializerError("Quadrilateral should have 4 points");
        }
        else{
            this.points = new Point[4];
            System.arraycopy(points, 0, this.points, 0, 4);
        }
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        if (points.length != 4){
            throw new ExceptionInInitializerError("Quadrilateral should have 4 points");
        }
        else{
            this.points = points;
        }
    }

    public void setPoint(Point point, int index) {
        points[index] = point;

    }

    public float calculatePerimeter(){
        float perimeter = 0;
        Point[] iterablePoints = makeIterablePointArray();

        for (int i = 0; i < points.length; i++){
            float distanceBetweenPoints = calculateDistanceBetweenPoints(iterablePoints[i], iterablePoints[i + 1]);
            perimeter += distanceBetweenPoints;
        }
        return perimeter;
    }

    public float calculateArea(){
        if (isSquare() || isRectangle()){
            return calculateSquareRectangleArea();
        }

        float semiPerimeter = calculatePerimeter() / 2;
        Point[] iterablePoints = makeIterablePointArray();
        float area = 1;

        for (int i = 0; i < points.length; i++){
            float distanceBetweenPoints = calculateDistanceBetweenPoints(iterablePoints[i], iterablePoints[i + 1]);
            area *= (semiPerimeter - distanceBetweenPoints);
        }

        area = (float)Math.sqrt(area);

        return area;

    }

    private float calculateSquareRectangleArea(){
        float area = 1;
        Point[] iterablePoints = makeIterablePointArray();

        for (int i = 0; i < 2; i++) {
            float distanceBetweenPoints = calculateDistanceBetweenPoints(iterablePoints[i], iterablePoints[i + 1]);
            area *= distanceBetweenPoints;
        }
        return area;
    }

    public boolean isArbitary(){
        return !isRectangle() && !isSquare();
    }

    public boolean isSquare(){
        if (isRectangle()){
            float oneSide = calculateDistanceBetweenPoints(points[0], points[1]);
            float anotherSide = calculateDistanceBetweenPoints(points[1], points[2]);

            return oneSide == anotherSide;
        }

        return false;
    }

    public boolean isRectangle(){
        Point[] iterablePoints = makeIterablePointArray();

        for (int i = 0; i < 2; i++){
            float angle = defineCosAngle(iterablePoints[i], iterablePoints[i + 1], iterablePoints[i + 2]);
            if (angle != 0){
                return false;
            }
        }

        return true;
    }

    private float defineCosAngle(Point fromFirstLine, Point commonPoint, Point toSecondLine){
        Vector vectorOfFirstLine = new Vector(fromFirstLine, commonPoint);
        Vector vectorOfSecondLine = new Vector(commonPoint, toSecondLine);
        float scalarProduct = calculateScalarProduct(
                vectorOfFirstLine,
                vectorOfSecondLine
                );
        if (scalarProduct == 0){
            return 0;
        }
        float productLengthsVectors = vectorOfFirstLine.getVectorLength() * vectorOfSecondLine.getVectorLength();
        return scalarProduct / productLengthsVectors;
    }

    private float calculateScalarProduct(Vector a, Vector b){
        float scalarProduct = 0;
        for (int i = 0; i < a.size(); i++){
            scalarProduct += a.getCoord(i) * b.getCoord(i);
        }
        return scalarProduct;
    }

    private float calculateDistanceBetweenPoints(Point from, Point to){
        float xDifference = to.getX() - from.getX();
        float yDifference = to.getY() - from.getY();
        return (float)Math.sqrt(xDifference * xDifference + yDifference * yDifference);
    }

    private Point[] makeIterablePointArray(){
        Point[] iterablePoints = new Point[5];
        System.arraycopy(points, 0, iterablePoints, 0, 4);
        iterablePoints[4] = points[0];
        return iterablePoints;
    }
}
