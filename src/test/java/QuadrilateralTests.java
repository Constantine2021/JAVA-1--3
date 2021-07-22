import Laba3.Point;
import Laba3.Quadrilateral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class QuadrilateralTests {

    Point[] squarePoints = new Point[]{
            new Point(0,0),
            new Point(5, 0),
            new Point(5, 5),
            new Point(0, 5)
    };
    private final Quadrilateral square = new Quadrilateral(squarePoints);

    Point[] rectanglePoints = new Point[]{
            new Point(0, 0),
            new Point(5, 0),
            new Point(5, 2),
            new Point(0, 2)
    };
    private final Quadrilateral rectangle = new Quadrilateral(rectanglePoints);

    Point[] arbitaryPoints = new Point[]{
            new Point(0, 0),
            new Point(4, 0),
            new Point(4, 2),
            new Point(0, 5)
    };
    private final Quadrilateral arbitary = new Quadrilateral(arbitaryPoints);

    @Test
    void squarePerimeterTest(){
        float expectedPerimeter = 20f;
        float actualPerimeter = square.calculatePerimeter();
        Assertions.assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    void rectanglePerimeterTest(){
        float expectedPerimeter = 14f;
        float actualPerimeter = rectangle.calculatePerimeter();
        Assertions.assertEquals(expectedPerimeter, actualPerimeter);

    }

    @Test
    void arbitaryPerimeterTest(){
        float expectedPerimeter = 16f;
        float actualPerimeter = arbitary.calculatePerimeter();
        Assertions.assertEquals(expectedPerimeter, actualPerimeter);

    }

    @Test
    void squareIsSquare(){
        Assertions.assertTrue(square.isSquare());
    }

    @Test
    void squareIsArbitary(){
        Assertions.assertFalse(square.isArbitary());
    }


    @Test
    void rectangleIsSquare(){
        Assertions.assertFalse(rectangle.isSquare());
    }

    @Test
    void rectangleIsArbitary(){
        Assertions.assertFalse(rectangle.isArbitary());
    }

    @Test
    void rectangleIsRectangle(){
        Assertions.assertTrue(rectangle.isRectangle());
    }

    @Test
    void arbitaryIsSquare(){
        Assertions.assertFalse(arbitary.isSquare());
    }

    @Test
    void arbitaryIsArbitary(){
        Assertions.assertTrue(arbitary.isArbitary());
    }

    @Test
    void arbitaryIsRectangle(){
        Assertions.assertFalse(arbitary.isRectangle());
    }


    @Test
    void squareAreaTest(){
        float expectedArea = 25f;
        float actualArea = square.calculateArea();
        Assertions.assertEquals(expectedArea, actualArea);
    }

    @Test
    void rectangleAreaTest() {
        float expectedArea = 10f;
        float actualArea = rectangle.calculateArea();
        Assertions.assertEquals(expectedArea, actualArea);
    }

    @Test
    void arbitaryAreaTest() {
        float expectedArea = 14f;
        float actualArea = (float) Math.floor(arbitary.calculateArea());
        Assertions.assertEquals(expectedArea, actualArea);
    }

}
