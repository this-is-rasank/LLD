package SOLID.liskovs_substitution;


class Car implements Vehicle{
    boolean engineState = false;
    boolean ACState = false;
    int speed = 0;

    public void turnOnEngine(){
        this.engineState = true;
    }

    public void accelerate(){
        this.speed += 2;
    }

    public void engineStatus(){
        String status = (this.engineState)?"On":"OFF";
        System.out.println("Engine Status: " + status);
    }

    public void vehicleSpeed(){
        System.out.println("Vehicle speed: " + this.speed);
    }

    public void turnOnAC(){
        this.ACState = true;
    }

    public void ACStatus(){
        String status = (this.ACState)?"On":"OFF";
        System.out.println("AC: " + status);
    }

}

public class Pass {
    public static void main(String[] args) {
        Vehicle vehicle1 = new MotorCycle();
        vehicle1.turnOnEngine();
        vehicle1.engineStatus();
        vehicle1.accelerate();
        vehicle1.accelerate();
        vehicle1.vehicleSpeed();


        // Can be substituted
        Vehicle vehicle2 = new Car();
        vehicle2.turnOnEngine();
        vehicle2.engineStatus();
        vehicle2.accelerate();
        vehicle2.accelerate();
        vehicle2.vehicleSpeed();

        // Adds more functionality
        Car bmw = new Car();
        bmw.turnOnAC();
        bmw.ACStatus();

    }
}
