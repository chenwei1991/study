package cw.demo.pattern.struct.composite;

public class Client {
    public static void main(String[] args) {
        /*
        让客户端可以忽略复杂的层次结构，使用统一的方式去操作层次结构中的所有对象
         */
        Path root = new Directory("C:");
        Path dir = root.createFile("文件夹1");
        Path file = root.createFile("aaa.txt");
        root.createFile("hello.java");
        dir.createFile("ccc.class");
        dir.createFile("1.mp3");
        System.out.println("------------------------");
        System.out.println(root.getName() + "下文件列表：");
        root.getFiles().forEach(t -> System.out.println(t.getName()));
        System.out.println("---------------------------------");
        file.delete();
        System.out.println(root.getName() + "下文件列表：");
        root.getFiles().forEach(t -> System.out.println(t.getName()));
        System.out.println("---------------------------------");
        dir.delete();
        System.out.println(root.getName() + "下文件列表：");
        root.getFiles().forEach(t -> System.out.println(t.getName()));
    }
}
