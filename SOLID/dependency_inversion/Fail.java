package SOLID.dependency_inversion;

// Classes should depend on interface rather than concrete class
// Same logic works for multiple concrete classes, Less redundancy, Less code

interface Mouse {
    public void click();

    public void scroll();
}

class WiredMouse implements Mouse {
    public void click() {
        System.out.println("Click via USB Input");
    }

    public void scroll() {
        System.out.println("Scroll via USB Input");
    }
}

class WirelessMouse implements Mouse {
    public void click() {
        System.out.println("Click via Bluetooth Input");
    }

    public void scroll() {
        System.out.println("Scroll via Bluetooth Input");
    }
}

class PCFail {
    WirelessMouse mouse;

    // PC class depending on concrete class of Mouse interface
    // it should depend on interface
    public PCFail() {
        this.mouse = new WirelessMouse();
    }

    public void whichMouse() {
        System.out.println("Wireless Mouse");
    }
}

public class Fail {
    public static void main(String[] args) {
        PCFail pc = new PCFail();
        pc.whichMouse();
    }
}
