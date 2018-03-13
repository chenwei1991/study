package cw.demo.pattern.create.singleton;

public class Singleton {
    private Singleton() {
    }

    private static class SingletonHelper {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.singleton;
    }

    public void func() {
        System.out.println("hello");
    }
}
