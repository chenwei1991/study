package cw.demo.pattern.create.builder;

public class IntelHardDisk extends HardDisk {
    @Override
    public void save() {
        System.out.println("Intel save");
    }
}
