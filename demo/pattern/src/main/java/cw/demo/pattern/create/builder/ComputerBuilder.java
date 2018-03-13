package cw.demo.pattern.create.builder;

public abstract class ComputerBuilder {
    public abstract void buildCPU();

    public abstract void buildHardDisk();

    public abstract Computer build();
}
