package cw.demo.pattern.create.builder;

public class Person {

    public Computer createPC(ComputerBuilder builder) {
        // 假设电脑必须先有cpu，后有硬盘，那么这个构建过程是由person来确定的。
        // 真实的构建者只负责真实产品的生产，Director（Person）负责控制构建的过程
        builder.buildCPU();
        builder.buildHardDisk();
        return builder.build();
    }
}
