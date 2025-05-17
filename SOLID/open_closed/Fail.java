package SOLID.open_closed;

// Open for Extention, Closed for Modification
// Modification is Bug Prone, Extention makes code scalable for future use

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

    public int calculateTotal() {
        int price = this.marker.price * this.quantity;
        return price;
    }

}

class InvoiceDaoFail {
    Invoice invoice;

    public InvoiceDaoFail(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        System.out.println("Saving to DB");
    }

    // If new feature of saving to file is needed
    public void saveToFile() {
        System.out.println("Saving to DB");
    }
}
