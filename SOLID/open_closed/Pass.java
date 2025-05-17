package SOLID.open_closed;

import SOLID.open_closed.*;

interface InvoiceDao {

    // abstract methods in interface
    // donot specify body
    public void save(Invoice invoice);
}

class DBInvoiceDao implements InvoiceDao {

    @Override
    public void save(Invoice invoice) {
        System.out.println("Saving to DB");
    }
}

class FileInvoiceDao implements InvoiceDao {

    @Override
    public void save(Invoice invoice) {
        System.out.println("Saving to File");
    }
}

public class Pass {
    public static void main(String[] args) {
        Marker marker = new Marker("WhiteBoard", "Blue", 2020, 50);
        Invoice invoice = new Invoice(marker, 10);
        int total = invoice.calculateTotal();
        System.out.println(total);
        FileInvoiceDao daoFile = new FileInvoiceDao();
        daoFile.save(invoice);
        DBInvoiceDao daoDB = new DBInvoiceDao();
        daoDB.save(invoice);
    }

}
