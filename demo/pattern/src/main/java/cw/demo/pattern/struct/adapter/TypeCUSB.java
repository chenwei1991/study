package cw.demo.pattern.struct.adapter;

public class TypeCUSB implements TypeC {
    @Override
    public void transmitData() {
        System.out.println("使用TypeC传输数据");
    }
}
