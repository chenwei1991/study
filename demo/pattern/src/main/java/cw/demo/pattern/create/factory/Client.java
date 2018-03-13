package cw.demo.pattern.create.factory;

public class Client {
    public static void main(String[] args) {
        Factory a = new ConcreteFactoryA();
        a.createProduct().func();
        Factory b =new ConcreteFactoryB();
        b.createProduct().func();
    }
}
