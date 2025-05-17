package SOLID.interface_segragation;

// interface should be divided into smaller and smaller parts
// until there is no reason for client to implement useless functions

interface ChefInterface {

    public void cookFood();

    public void expertise();

}

interface WaiterInterface {

    public void takeOrder();

    public void serveOrder();

}

class Chef implements ChefInterface {
    String expertIn;

    public Chef(String expertise) {
        this.expertIn = expertise;
    }

    public void cookFood() {
        System.out.println("Cooking");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cooked");

    }

    public void expertise() {
        System.out.println(this.expertIn);
    }
}

public class Pass {
    public static void main(String[] args) {
        ChefInterface chef = new Chef("Italian");
        chef.cookFood();
        chef.expertise();
    }
}
