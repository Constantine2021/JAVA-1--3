package Laba3;
/*
Train: Пункт назначения, Номер поезда, Время отправления, Число мест
(общих, купе, плацкарт, люкс).
Создать массив объектов. Вывести:
a) список поездов, следующих до заданного пункта назначения;
b) список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа;
c) список поездов, отправляющихся до заданного пункта назначения
и имеющих общие места.

. Определить класс Прямая на плоскости (пространстве). Определить точки
пересечения прямой с осями координат. Определить координаты пересечения двух прямых. Создать массив/список/множество объектов и определить
группы параллельных прямых.

Определить класс Четырехугольник на плоскости, вершины которого имеют
тип Точка. Определить площадь и периметр четырехугольника. Создать массив/список/множество объектов и подсчитать количество четырехугольников
разного типа (квадрат, прямоугольник, ромб, произвольный). Определить для
каждой группы наибольший и наименьший по площади (периметру) объект.
 */
import java.time.LocalTime;

public class Lab3 {
    public static void main(String[] args){
        Seat[] seats = new Seat[]{
                new Seat(Seat.SeatType.CommonSeat, 2),
                new Seat(Seat.SeatType.Coupe, 3),
                new Seat(Seat.SeatType.Luxury, 5)
        };
        Train a = new Train("Saint-Petersburg", "222", LocalTime.of(14, 59), seats);
        Train b = new Train("Moscow", "523", LocalTime.of(12, 33), seats);
        b.addSeats(Seat.SeatType.ReservedSeat, 10);
        b.setSeat(Seat.SeatType.Coupe, 5);
        b.setSeat(Seat.SeatType.CommonSeat, 3);

        TrainArray trainArray = new TrainArray(a, b);
        trainArray.showTrains();

        trainArray.showWithDestination(" Moscow");
        trainArray.showWithDestinationAndTime("Moscow", LocalTime.of(12, 0));
        trainArray.showWithDestinationAndCommonSeats("Moscow");

        Quadrilateral square = new Quadrilateral(
                new Point(0,0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3)
        );

        Quadrilateral square1 = new Quadrilateral(
                new Point(0,0),
                new Point(10, 0),
                new Point(10, 10),
                new Point(0, 10)
        );

        Quadrilateral square2 = new Quadrilateral(
                new Point(0,0),
                new Point(8, 0),
                new Point(8, 8),
                new Point(0, 8)
        );

        Quadrilateral rectangle = new Quadrilateral(
                new Point(0, 0),
                new Point(5, 0),
                new Point(5, 2),
                new Point(0, 2)
        );

        Quadrilateral rectangle1 = new Quadrilateral(
                new Point(0, 0),
                new Point(8, 0),
                new Point(8, 2),
                new Point(0, 2)
        );

        Quadrilateral rectangle2 = new Quadrilateral(
                new Point(0, 0),
                new Point(5, 0),
                new Point(5, 10),
                new Point(0, 10)
        );

        Quadrilateral arbitary = new Quadrilateral(
                new Point(0, 0),
                new Point(4, 0),
                new Point(4, 2),
                new Point(0, 5)
        );

        QuadrilateralHashtable quadrilateralHashtable = new QuadrilateralHashtable(
                square,
                rectangle,
                arbitary,
                square1,
                square2,
                rectangle1,
                rectangle2
        );

        System.out.println(quadrilateralHashtable.toString());

        System.out.println("Min square perimeter: " + quadrilateralHashtable.findMinPerimeter(QuadrilateralHashtable.QuadrilateralType.Square));
        System.out.println("Max square perimeter: " + quadrilateralHashtable.findMaxPerimeter(QuadrilateralHashtable.QuadrilateralType.Square));

        System.out.println("Min square area: " + quadrilateralHashtable.findMinArea(QuadrilateralHashtable.QuadrilateralType.Square));
        System.out.println("Max square area: " + quadrilateralHashtable.findMaxArea(QuadrilateralHashtable.QuadrilateralType.Square));
        System.out.println();

        System.out.println("Min rectangle perimeter: " + quadrilateralHashtable.findMinPerimeter(QuadrilateralHashtable.QuadrilateralType.Rectangle));
        System.out.println("Max rectangle perimeter: " + quadrilateralHashtable.findMaxPerimeter(QuadrilateralHashtable.QuadrilateralType.Rectangle));

        System.out.println("Min rectangle area: " + quadrilateralHashtable.findMinArea(QuadrilateralHashtable.QuadrilateralType.Rectangle));
        System.out.println("Max rectangle area: " + quadrilateralHashtable.findMaxArea(QuadrilateralHashtable.QuadrilateralType.Rectangle));
        System.out.println();

        System.out.println("Min arbitary perimeter: " + quadrilateralHashtable.findMinPerimeter(QuadrilateralHashtable.QuadrilateralType.Arbitary));
        System.out.println("Max arbitary perimeter: " + quadrilateralHashtable.findMaxPerimeter(QuadrilateralHashtable.QuadrilateralType.Arbitary));

        System.out.println("Min arbitary area: " + quadrilateralHashtable.findMinArea(QuadrilateralHashtable.QuadrilateralType.Arbitary));
        System.out.println("Max arbitary area: " + quadrilateralHashtable.findMaxArea(QuadrilateralHashtable.QuadrilateralType.Arbitary));
        System.out.println();
    }
}
