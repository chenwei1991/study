package cw.demo.pattern.struct.facade;

public class Client {
    public static void main(String[] args) {
        /*
        为子系统中的一组接口提供一个统一的高层接口。这一接口使得子系统更加容易使用。
        在分层架构中得以体现
         */
        new Calc().calc();
    }
}
