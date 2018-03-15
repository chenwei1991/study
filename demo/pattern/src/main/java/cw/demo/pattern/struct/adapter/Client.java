package cw.demo.pattern.struct.adapter;

public class Client {
    public static void main(String[] args) {
        TypeC typeC = new TypeCUSB();
        typeC.transmitData();

        MicroUSB microUSB = new MicroUSB();
        TypeC typeC1 = new MicroAdapter(microUSB);
        typeC1.transmitData();
    }
}
