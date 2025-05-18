package DesignPatterns.Structural.DecoratorDesignPattern;

// Implementing Pizza toppings as decorators

// Base class
interface BasePizza {
    public int cost();
}

class Margarita implements BasePizza {
    public int cost() {
        System.out.println("100");
        return 100;
    }
}

class FarmHouse implements BasePizza {
    public int cost() {
        System.out.println("150");
        return 150;
    }
}

// Decorators(Toppings)

// is a
class JalapenoTopping implements BasePizza {
    // has a
    BasePizza basePizza;

    public JalapenoTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    public int cost() {
        // using has a relation to calculate lower layer costs
        int baseCost = this.basePizza.cost();
        System.out.println("+30");
        return baseCost + 30;
    }
}

class PaneerTopping implements BasePizza {
    BasePizza basePizza;

    public PaneerTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    public int cost() {
        int baseCost = this.basePizza.cost();
        System.out.println("+50");
        return baseCost + 50;
    }
}

class OnionTopping implements BasePizza {
    BasePizza basePizza;

    public OnionTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    public int cost() {
        int baseCost = this.basePizza.cost();
        System.out.println("+20");
        return baseCost + 20;
    }
}

public class DecoratorMain {
    public static void main(String[] args) {
        BasePizza pizza1 = new OnionTopping(new JalapenoTopping(new PaneerTopping(new FarmHouse())));
        System.out.println("=" + pizza1.cost() + "\n");

        BasePizza pizza2 = new JalapenoTopping(new PaneerTopping(new Margarita()));
        System.out.println("=" + pizza2.cost());

    }
}
