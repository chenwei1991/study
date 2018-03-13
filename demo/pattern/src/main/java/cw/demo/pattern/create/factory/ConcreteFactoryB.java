package cw.demo.pattern.create.factory;


public class ConcreteFactoryB extends Factory {
    @Override
    Product createProduct() {
        return new ConcreteProductB();
    }
}
