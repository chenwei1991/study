package cw.demo.pattern.struct.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Path {
    private String name;
    private Path dir;

    private List<Path> files;

    public Directory(String name) {
        this.files = new ArrayList<>();
        this.name = name;
    }

    public Directory(String name, Path dir) {
        this.files = new ArrayList<>();
        this.name = name;
        this.dir = dir;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void delete() {
        if (this.dir == null) {
            System.out.println("根目录不支持删除");
            return;
        }
        ArrayList<Path> copy = new ArrayList<>(files);
        copy.forEach(t -> t.delete());
        copy = null;
        this.dir.deleteFile(this.name);
    }

    @Override
    public Path createFile(String name) {
        Path p;
        p = name.contains(".") ? new File(name, this) : new Directory(name, this);
        this.files.add(p);
        System.out.println("在" + this.name + "中创建" + name + "成功");
        return p;
    }

    @Override
    public void deleteFile(String name) {
        Path path = this.files.stream().filter(t -> t.getName().equals(name)).findFirst().get();
        this.files.remove(path);
        System.out.println(name + "从" + this.name + "中删除");
    }

    @Override
    public List<Path> getFiles() {
        return this.files;
    }
}
