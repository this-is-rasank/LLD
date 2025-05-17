package SOLID.interface_segragation;
import java.lang.Thread;

// Interfaces should be such that, client should not need to implement unnecessary features they do not need

interface RestaurantEmployee {

    public void cleanDishes();

    public void cookFood();

    public void serveCustomers();
    
}

class ChefFail implements RestaurantEmployee{
    public void cookFood(){
        System.out.println("Cooking");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cooked");

    }

    // not needed
    public void cleanDishes(){
    
    }

    // not needed
    public void serveCustomers(){

    }
}
public class Fail {
    public static void main(String[] args) {
        RestaurantEmployee chef = new ChefFail();
        chef.cookFood();
    }
}
