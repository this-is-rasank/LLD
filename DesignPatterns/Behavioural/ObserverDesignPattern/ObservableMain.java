package DesignPatterns.Behavioural.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

interface Observable {
    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();

    public void addStock(int stock);

    public int getData();
}

class IphoneObservable implements Observable {
    int data;
    List<Observer> observers;

    public IphoneObservable(int data) {
        this.data = data;
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public void addStock(int stock) {
        int old_stock = this.data;
        this.data += stock;
        if (old_stock == 0) {
            notifyObservers();
        }
    }

    public int getData() {
        return this.data;
    }
}

public class ObservableMain {
    public static void main(String args[]) {
        Observable IphoneObseravleInstance = new IphoneObservable(0);
        IphoneObseravleInstance.addObserver(new EmailNotificationObserver("abc@xyz.com", IphoneObseravleInstance));
        IphoneObseravleInstance.addObserver(new MobileNotificationObserver("9876543210", IphoneObseravleInstance));
        IphoneObseravleInstance.addObserver(new EmailNotificationObserver("abcd@xyz.com", IphoneObseravleInstance));
        IphoneObseravleInstance.addObserver(new MobileNotificationObserver("9876543219", IphoneObseravleInstance));
        IphoneObseravleInstance.addStock(15);
    }
}
