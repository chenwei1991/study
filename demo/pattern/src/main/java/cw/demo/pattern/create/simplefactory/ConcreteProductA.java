package cw.demo.pattern.create.simplefactory;

public class ConcreteProductA implements Product {
    @Override
    public void func() {
        System.out.println("完成A功能");
    }
}
