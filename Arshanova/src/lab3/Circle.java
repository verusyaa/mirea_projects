package lab3;

public class Circle extends Shape {
    protected double radius;

    public Circle() {
        super();
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {
        return "Окружность с радиусом " + getRadius() + " с такими параметрами цвета и плотности как " + getColor() + isFilled() + " имеет такие показатели площади и периметра как " + getArea() + getPerimeter();
    }
}
