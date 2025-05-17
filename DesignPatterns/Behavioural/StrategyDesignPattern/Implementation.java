package DesignPatterns.Behavioural.StrategyDesignPattern;

import java.util.ArrayList;
import java.util.List;

// If not using any Strategy, Code will become redundant as shown in example
// Strategy design pattern is used such that it removes any duplicacy by creating parent classes for redundant features

// Parent

class Car {
    DriveStrategy driveStrategy;

    public Car(DriveStrategy dS) {
        this.driveStrategy = dS;
    }

    public void drive() {
        this.driveStrategy.drive();
    }
}

// Driving Strategies

interface DriveStrategy {
    public void drive();
}

class FastDrive implements DriveStrategy {
    public void drive() {
        System.out.println("Drives Fast");
    }
}

class NormalDrive implements DriveStrategy {
    public void drive() {
        System.out.println("Drives Normal");
    }
}

// Child Classes of Car

class NormalCar extends Car {

    // Passing in Car constructor
    public NormalCar() {
        super(new NormalDrive());
    }
}

class OffRoadCar extends Car {
    public OffRoadCar() {
        super(new FastDrive());
    }
}

class SportsCar extends Car {
    public SportsCar() {
        super(new FastDrive());
    }
}

public class Implementation {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(3);
        cars.add(new NormalCar());
        cars.add(new OffRoadCar());
        cars.add(new SportsCar());

        for (Car car : cars) {
            car.drive();
        }
    }

}
