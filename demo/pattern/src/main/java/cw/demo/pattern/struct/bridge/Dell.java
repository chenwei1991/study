package cw.demo.pattern.struct.bridge;

public class Dell implements Brand {
    @Override
    public void show() {
        System.out.println("戴尔品牌");
    }
}
