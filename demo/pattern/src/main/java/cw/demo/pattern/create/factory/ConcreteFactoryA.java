package cw.demo.pattern.create.factory;

public class ConcreteFactoryA extends Factory {
    @Override
    Product createProduct() {
        return new ConcreteProductA();
    }

}
