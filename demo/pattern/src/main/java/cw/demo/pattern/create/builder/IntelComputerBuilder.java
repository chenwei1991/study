package cw.demo.pattern.create.builder;

public class IntelComputerBuilder extends ComputerBuilder {
    private Computer computer=new Computer();

    @Override
    public void buildCPU() {
        this.computer.setCpu(new IntelCPU());
    }

    @Override
    public void buildHardDisk() {
        this.computer.setHardDisk(new IntelHardDisk());
    }

    @Override
    public Computer build() {
        return computer;
    }
}
