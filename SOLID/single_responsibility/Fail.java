
// Single Responsibility
// Each class must change by only 1 dependency
// Helps with readability, isolation of concerns/logics

class Marker {
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}

class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    // Here Invoice class can be changed if there is logic change in any of the
    // member functions written below
    // Hence, it does not follow single responsibility

    public int calculateTotal() {
        int price = this.marker.price * this.quantity;
        return price;
    }

    public void printInvoice() {
        System.out.println("Invoice");
    }

    public void saveToDB() {
        // Save in DB
    }

}

public class Fail {
    public static void main(String args[]) {

        Marker marker = new Marker("WhiteBoard", "Blue", 2020, 50);
        Invoice invoice = new Invoice(marker, 10);
        int total = invoice.calculateTotal();
        System.out.println(total);
        invoice.printInvoice();

    }
}
