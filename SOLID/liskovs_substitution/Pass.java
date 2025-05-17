package SOLID.liskovs_substitution;

interface Vehicle {
    public void accelerate();

    public void vehicleSpeed();
}

interface EngineVehicle extends Vehicle {
    public void turnOnEngine();

    public void engineStatus();
}

class MotorCycle implements EngineVehicle {
    boolean engineState = false;
    int speed = 0;

    public void turnOnEngine() {
        this.engineState = true;
    }

    public void accelerate() {
        this.speed += 10;
    }

    public void engineStatus() {
        String status = (this.engineState) ? "On" : "OFF";
        System.out.println("Engine Status: " + status);
    }

    public void vehicleSpeed() {
        System.out.println("Vehicle speed: " + this.speed);
    }
}

class Bicycle implements Vehicle {
    int speed = 0;

    public void accelerate() {
        this.speed += 2;
    }

    public void vehicleSpeed() {
        System.out.println("Vehicle speed: " + this.speed);
    }
}

public class Pass {
    public static void main(String[] args) {
        Vehicle vehicle1 = new MotorCycle();
        // these methods can only be called by EngineVehicle class
        // vehicle1.turnOnEngine();
        // vehicle1.engineStatus();

        // So the code does not break for bicycle
        vehicle1.accelerate();
        vehicle1.vehicleSpeed();

        // Can be substituted
        Vehicle vehicle2 = new Bicycle();
        vehicle2.accelerate();
        vehicle2.accelerate();
        vehicle2.vehicleSpeed();
    }
}
