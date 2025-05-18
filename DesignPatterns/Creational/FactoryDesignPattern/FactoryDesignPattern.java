package DesignPatterns.Creational.FactoryDesignPattern;

class Factory {
    Shape shape;

    public Factory(String shape) {
        // Business logic for has-a object
        if (shape == "Circle") {
            this.shape = new Circle();
        } else if (shape == "Square") {
            this.shape = new Square();
        } else {
            this.shape = new Rectangle();
        }
    }

    public void drawAndFillColor(String color) {
        this.shape.draw();
        System.out.println("Filling color: " + color);
    }
}

interface Shape {
    public void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        Factory f1 = new Factory("Circle");
        f1.drawAndFillColor("Blue");
    }

}
