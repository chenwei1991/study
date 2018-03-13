package cw.demo.pattern.create.abstractfactory;

public class Client {
    public static void main(String[] args) {
        Factory a = new ConcreteFactoryA();
        a.createProduct().func();
        a.createTool().func();
        Factory b =new ConcreteFactoryB();
        b.createProduct().func();
        b.createTool().func();
    }
}
