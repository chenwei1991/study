package cw.demo.pattern.struct.decorator;

public class SimpleWindow implements Window {
    @Override
    public void open() {
        System.out.println("打开窗户透气");
    }
}
