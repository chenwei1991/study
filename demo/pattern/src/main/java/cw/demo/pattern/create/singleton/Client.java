package cw.demo.pattern.create.singleton;

public class Client {
    public static void main(String[] args) {
        /**
         * 单例有多种模式实现，推荐使用枚举实现，简单安全
         */
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1);

        EnumSingleton singleton = EnumSingleton.INSTANCE;
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        System.out.println(singleton1.compareTo(singleton));
    }
}
