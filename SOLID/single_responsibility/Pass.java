
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

    // Here Invoice class only 1 reason to change
    // Other reasons have been shifted to other classes
    // The other classes can also inherit the Invoice class then it will become
    // Extention

    public int calculateTotal() {
        int price = this.marker.price * this.quantity;
        return price;
    }

}

class InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        System.out.println("Saving to DB");
    }
}

class PrintInvoice {
    Invoice invoice;

    public PrintInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void print() {
        System.out.println("Printing");
    }
}

public class Pass {
    public static void main(String args[]) {

        Marker marker = new Marker("WhiteBoard", "Blue", 2020, 50);
        Invoice invoice = new Invoice(marker, 10);
        int total = invoice.calculateTotal();
        System.out.println(total);
        InvoiceDao dao = new InvoiceDao(invoice);
        dao.saveToDB();
        PrintInvoice printer = new PrintInvoice(invoice);
        printer.print();

    }
}
