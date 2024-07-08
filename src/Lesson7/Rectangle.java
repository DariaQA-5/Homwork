package Lesson7;

public class Rectangle extends GeometricFigure {
    public double width;
    public double length;

    public Rectangle(double aSide, double bSide, Color areaColor, Color borderColor) {
        super(areaColor, borderColor);
        this.width = aSide;
        this.length = bSide;
    }

    @Override
    public double perimeter() {
        return 2 * (width + length);
    }

    @Override
    public double area() {
        return width * length;
    }

    public void showInfo() {
        System.out.println("\nПериметр прямоугольника = " + perimeter() +
                "\nПлощадь прямоугольника = " + area() +
                "\nЦвет заливки: " + areaColor +
                "\nЦвет границы: " + borderColor);
    }
}


