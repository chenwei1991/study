package cw.demo.pattern.struct.decorator;

public class AntitheftWindow implements Window {

    private Window window;

    public AntitheftWindow(Window window) {
        this.window = window;
    }

    @Override
    public void open() {
        System.out.println("加装了防盗网，有防盗功能");
        this.window.open();
    }
}
