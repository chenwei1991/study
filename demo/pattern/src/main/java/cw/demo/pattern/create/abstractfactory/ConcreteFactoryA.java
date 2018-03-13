package cw.demo.pattern.create.abstractfactory;

public class ConcreteFactoryA extends Factory {
    @Override
    Product createProduct() {
        return new ConcreteProductA();
    }

    @Override
    Tool createTool() {
        return new ConcreteToolA();
    }
}
