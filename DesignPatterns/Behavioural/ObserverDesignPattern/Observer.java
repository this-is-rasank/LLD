package DesignPatterns.Behavioural.ObserverDesignPattern;

interface Observer {
    public void update();
}

class EmailNotificationObserver implements Observer {
    String email;
    Observable observable;

    public EmailNotificationObserver(String email, Observable observable) {
        this.email = email;
        this.observable = observable;
    }

    public void update() {
        System.out.println("Send email to :" + email + ". With data: " + this.observable.getData());
    }
}

class MobileNotificationObserver implements Observer {
    String number;
    Observable observable;

    public MobileNotificationObserver(String number, Observable observable) {
        this.number = number;
        this.observable = observable;
    }

    public void update() {
        System.out.println("Send SMS to :" + this.number + ". With data: " + this.observable.getData());
    }
}
