package cw.demo.pattern.create.prototype;

public class Money implements Cloneable {
    private String country;
    private int value;

    public Money(String country, int value) {
        this.country = country;
        this.value = value;
    }

    public void show() {
        System.out.println("国家:" + country + " 面额:" + value);
    }

    @Override
    public Object clone() {
        Object object = null;
        try {
            // 底层是通过内存拷贝实现的对象复制，不会执行类的构造方法
            // 只实现了浅拷贝，深拷贝需要手动实现
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return object;
    }
}
