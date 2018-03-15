package cw.demo.pattern.struct.facade;

public class Calc {
    public void calc(){
        new KeyBoard().in();
        Memory memory = new Memory();
        memory.save();
        new CPU().run();
        memory.save();
        new Screen().display();
    }
}
