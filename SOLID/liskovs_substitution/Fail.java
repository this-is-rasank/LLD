package SOLID.liskovs_substitution;

// If a new class is subtype of original, it should be able replace original's object
// without breaking the behaviour of the program

// In other words, class should extend the capability of another class not narrow it down 

interface Vehicle{
    public void turnOnEngine();
    public void accelerate();
    public void engineStatus();
    public void vehicleSpeed();
}

// existing code
class MotorCycle implements Vehicle{
    boolean engineState = false;
    int speed = 0;

    public void turnOnEngine(){
        this.engineState = true;
    }

    public void accelerate(){
        this.speed += 10;
    }

    public void engineStatus(){
        String status = (this.engineState)?"On":"OFF";
        System.out.println("Engine Status: " + status);
    }

    public void vehicleSpeed(){
        System.out.println("Vehicle speed: " + this.speed);
    }
}

// new code to implement
class Bicycle implements Vehicle{
    int speed = 0;

    public void turnOnEngine(){
        throw new AssertionError("There is no engine");
    }

    public void accelerate(){
        this.speed += 2;
    }

    public void engineStatus(){
        System.out.println("There is no engine");
    }

    public void vehicleSpeed(){
        System.out.println("Vehicle speed: " + this.speed);
    }
}



public class Fail {
    public static void main(String[] args) {
        Vehicle vehicle1 = new MotorCycle();
        vehicle1.turnOnEngine();
        vehicle1.engineStatus();
        vehicle1.accelerate();
        vehicle1.accelerate();
        vehicle1.vehicleSpeed();


        // Can not be substituted
        Vehicle vehicle2 = new Bicycle();
        // throws error
        vehicle2.turnOnEngine();
        vehicle2.engineStatus();
        vehicle2.accelerate();
        vehicle2.accelerate();
        vehicle2.vehicleSpeed();
    }
    
}
