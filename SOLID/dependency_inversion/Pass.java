package SOLID.dependency_inversion;

import SOLID.dependency_inversion.*;

class PC {
    // Abstract mouse
    Mouse mouse;

    public PC(Mouse mouse) {
        this.mouse = mouse;
    }

    public void whichMouse() {
        System.out.println(this.mouse.getClass());
    }
}

public class Pass {
    public static void main(String[] args) {
        Mouse mouse = new WiredMouse();
        PC pc = new PC(mouse);
        pc.whichMouse();
    }
}
