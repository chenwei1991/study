package cw.demo.pattern.struct.bridge;

public class Apple implements Brand {
    @Override
    public void show() {
        System.out.println("苹果牌");
    }
}
