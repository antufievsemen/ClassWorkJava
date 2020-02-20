package ru.spbstu.main;

import ru.spbstu.main.shapes.Circle;
import ru.spbstu.main.shapes.Rectangle;
import ru.spbstu.main.shapes.Shape;
import ru.spbstu.main.shapes.Triangle;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];

        Shape shape1 = new Circle(1, 2, 3);
        Rectangle shape2 = new Rectangle(1, 2, 3, 5, 30);
        Triangle shape3 = new Triangle(1, 2, 4, 5, 3, 2);
        Circle shape4 = new Circle(6, 7, 12);
        Rectangle shape5 = new Rectangle(6, 15, 14, 2, 89);
        Triangle shape6 = new Triangle(12, 15, 66, 55, 33, 22);
        Rectangle shape7 = new Rectangle(1, 2, 3, 5, 360);
        Triangle shape8 = new Triangle(11, 21, 41, 51, 31, 123);
        Circle shape9 = new Circle(12, 22, 22);
        Rectangle shape10 = new Rectangle(11, 16, 18, 15, 123);

        shapes[0] = shape1;
        shapes[1] = shape2;
        shapes[2] = shape3;
        shapes[3] = shape4;
        shapes[4] = shape5;
        shapes[5] = shape6;
        shapes[6] = shape7;
        shapes[7] = shape8;
        shapes[8] = shape9;
        shapes[9] = shape10;

        double maxArea = 0;

        for(Shape figure:shapes){
            if(maxArea < figure.getArea()){
                maxArea = figure.getArea();
            }
        }

        System.out.print(Main.findMaxArea(shapes).getArea());
        /*
         * TODO: Выполнить действия над массивом 'shapes'
         *
         * 1. Проинициализировать переменную 'shapes' массивом
         *    содержащим 10 произвольных фигур. Массив должен
         *    содержать экземпляры классов Circle, Rectangle
         *    и Triangle.
         *
         * 2. Найти в массиве 'shapes' фигуру с максимальной
         *    площадью. Для поиска фигуры необходимо создать
         *    статический метод в текущем классе (Main).
         */
    }

    public static Shape findMaxArea(Shape[] shapes){
        if(shapes.length <= 0){
            System.exit(1);
        }

        double maxArea = 0;
        int numberOfShape = 0;

        for(int i = 0; i < shapes.length; i++){
            if(maxArea < shapes[i].getArea()){
                maxArea = shapes[i].getArea();
                numberOfShape = i;
            }
        }
        return shapes[numberOfShape];
    }
}
