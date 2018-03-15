package cw.demo.pattern.struct.adapter;

public class MicroAdapter implements TypeC {

    // 这里使用了组合的方式，来进行适配，是对象适配器，主要用于复用原有的功能，并适配当前的接口。
    // 也可以通过继承MicroUSB的方式，来进行适配，是类适配器，主要用于提供缺省实现，避免子类实现不必要的接口
    // 适配器模式主要用于，现有代码不可改动（外部jar包），而我们需要利用其中某一个类的功能（通俗点说可以说是方法），但是我们的客户端只认识另外一个和这个类结构不相关的接口，我们可以将这个现有的类与我们的目标接口进行适配，最终获得一个符合需要的接口并且包含待复用的类的功能的类。
    // 适配器模式是补救措施，所以在系统设计过程中请忘掉这个设计模式，这个模式只是在你无可奈何时的补救方式。
    private MicroUSB microUSB;


    public MicroAdapter(MicroUSB microUSB) {
        this.microUSB = microUSB;
    }

    @Override
    public void transmitData() {
        microUSB.transmitData();
    }
}
