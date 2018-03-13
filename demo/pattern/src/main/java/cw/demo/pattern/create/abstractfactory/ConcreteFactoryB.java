package cw.demo.pattern.create.abstractfactory;

public class ConcreteFactoryB extends Factory {
    @Override
    Product createProduct() {
        return new ConcreteProductB();
    }

    @Override
    Tool createTool() {
        return new ConcreteToolB();
    }
}
