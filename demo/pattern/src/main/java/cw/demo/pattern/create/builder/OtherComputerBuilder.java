package cw.demo.pattern.create.builder;

public class OtherComputerBuilder extends ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void buildCPU() {
        this.computer.setCpu(new AmdCPU());
    }

    @Override
    public void buildHardDisk() {
        this.computer.setHardDisk(new SamsungHardDisk());
    }

    @Override
    public Computer build() {
        return computer;
    }
}
