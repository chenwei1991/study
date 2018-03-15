package cw.demo.pattern.struct.bridge;

public abstract class Computer {
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public abstract void run();
}
