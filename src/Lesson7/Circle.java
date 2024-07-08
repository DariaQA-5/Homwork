package Lesson7;
public class Circle extends GeometricFigure {
    private double radius;

    public Circle(double radius, Color areaColor, Color borderColor) {
        super(areaColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 3 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }

    public void showInfo() {
        System.out.println("\nПериметр круга = " + perimeter() +
                "\nПлощадь круга = " + area() +
                "\nЦвет заливки: " + areaColor +
                "\nЦвет границы: " + borderColor);
    }
}
