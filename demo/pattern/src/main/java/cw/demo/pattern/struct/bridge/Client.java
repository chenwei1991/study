package cw.demo.pattern.struct.bridge;

public class Client {
    public static void main(String[] args) {
        /*
        多个维度变化的时候，考虑使用桥接模式，抽象（Computer）跟实现（Brand）同时支持扩展
         */
        Computer c1 = new Pad(new Dell());
        c1.run();

        Computer c2 = new NoteBook(new Apple());
        c2.run();
    }
}
