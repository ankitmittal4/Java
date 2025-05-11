abstract class Shape {
    abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // @Override
    double calculateArea() {
        
        return Math.PI * radius * radius;
    }

}

public class Main {
    public static void main(String[] args) {
        double r = 4.0;
        Circle circle = new Circle(r);
        System.out.println("Radius of the Circle: " + r);
        System.out.println("Area of the Circle: " + circle.calculateArea());
    }
}