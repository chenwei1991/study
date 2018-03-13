package cw.demo.pattern.create.simplefactory;

public class Client {
    public static void main(String[] args) {
        /**
         * 产品发生变化时，客户端无需需改，但工厂类需要修改
         */
        ProductFactory factory = new ProductFactory();
        Product a = factory.createProduct("A");
        Product b = factory.createProduct("B");
        a.func();
        b.func();
    }
}
