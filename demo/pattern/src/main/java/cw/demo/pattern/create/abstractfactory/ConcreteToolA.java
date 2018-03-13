package cw.demo.pattern.create.abstractfactory;

public class ConcreteToolA implements Tool {
    @Override
    public void func() {
        System.out.println("工具A完成功能");
    }
}
