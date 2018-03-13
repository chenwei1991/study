package cw.demo.pattern.create.builder;

public class Computer {
    private CPU cpu;
    private HardDisk hardDisk;

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void run() {
        this.cpu.calc();
        this.hardDisk.save();
    }
}
