package cw.demo.pattern.create.simplefactory;

public class ProductFactory {
    public Product createProduct(String name) {
        switch (name) {
            case "A":
                return new ConcreteProductA();
            case "B":
                return new ConcrectProductB();
            default:
                throw new RuntimeException("不支持的产生类型");
        }
    }
}
