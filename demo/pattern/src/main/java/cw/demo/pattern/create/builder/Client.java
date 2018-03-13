package cw.demo.pattern.create.builder;

public class Client {
    public static void main(String[] args) {
        Person person = new Person();
        ComputerBuilder builder = new IntelComputerBuilder();
        Computer pc = person.createPC(builder);
        pc.run();
        System.out.println("-----------");
        ComputerBuilder builder1 = new OtherComputerBuilder();
        Computer pc1 = person.createPC(builder1);
        pc1.run();
    }

}
