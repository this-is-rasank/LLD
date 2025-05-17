package DesignPatterns.Behavioural.StrategyDesignPattern;

import java.util.ArrayList;
import java.util.List;

// If not using any Strategy, Code will become redundant as shown in example
// Strategy design pattern is used such that it removes any duplicacy by creating parent classes for redundant features

class Car {
    public void drive() {
        System.out.println("Drives Normal");
    };
}

class OffRoadCar extends Car {
    @Override
    public void drive() {
        System.out.println("Drives Fast");
    };
}

class NormalCar extends Car {
}

class SportsCar extends Car {
    @Override
    public void drive() {
        // Duplicated code similar to OffRoadCar
        System.out.println("Drives Fast");
    }
}

public class Requirement {
    public static void main(String[] args) {
        // Array- Fixed Size, Can't use add
        // Car[] cars = new Car[3];
        // cars[0] = new NormalCar();

        // List is like vector in C++
        List<Car> cars = new ArrayList<>(3);
        cars.add(new NormalCar());
        cars.add(new OffRoadCar());
        cars.add(new SportsCar());

        for (Car car : cars) {
            car.drive();
        }
    }
}
