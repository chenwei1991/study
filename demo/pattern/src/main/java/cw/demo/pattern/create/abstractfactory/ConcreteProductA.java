package cw.demo.pattern.create.abstractfactory;

public class ConcreteProductA implements Product {
    @Override
    public void func() {
        System.out.println("产品A完成功能");
    }
}
