package Lesson7;
public class Geometric{
public static void main(String[] args) {
    // Создаем фигуры
    Circle circle = new Circle(5.0, "Red", "Black");
    Rectangle rectangle = new Rectangle(4.0, 6.0, "Blue", "Green");
    Triangle triangle = new Triangle(3.0, 4.0, 5.0, "Yellow", "Purple");

    // Выводим результаты
    System.out.println("Circle:");
    System.out.println("Perimeter: " + circle.getPerimeter());
    System.out.println("Area: " + circle.getArea());
    System.out.println("Fill color: " + circle.getFillColor());
    System.out.println("Border color: " + circle.getBorderColor());
    System.out.println();

    System.out.println("Rectangle:");
    System.out.println("Perimeter: " + rectangle.getPerimeter());
    System.out.println("Area: " + rectangle.getArea());
    System.out.println("Fill color: " + rectangle.getFillColor());
    System.out.println("Border color: " + rectangle.getBorderColor());
    System.out.println();

    System.out.println("Triangle:");
    System.out.println("Perimeter: " + triangle.getPerimeter());
    System.out.println("Area: " + triangle.getArea());
    System.out.println("Fill color: " + triangle.getFillColor());
    System.out.println("Border color: " + triangle.getBorderColor());
}
}