package Lesson7;

public class Triangle extends GeometricFigure {
    public double aSide;
    public double bSide;
    public double cSide;
    public Triangle(double aSide, double bSide, double cSide, Color areaColor, Color boderColor) {
        super(areaColor, boderColor);
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    @Override
    public double perimeter() {
        return aSide + bSide + cSide;
    }

    @Override
    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - aSide) * (p - bSide) * (p - cSide));
    }

    public void showInfo() {
        System.out.println("\nПериметр треугольника = " + perimeter() +
                "\nПлощадь треугольника = " + area() +
                "\nЦвет заливки: " + areaColor +
                "\nЦвет границы: " + borderColor);
    }
}
