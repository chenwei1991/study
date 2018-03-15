package cw.demo.pattern.struct.decorator;

public class Client {
    public static void main(String[] args) {
        /*
        通过组合的方式，拓展类的功能
         */
        Window window = new AntitheftWindow(new SimpleWindow());
        window.open();
    }
}
