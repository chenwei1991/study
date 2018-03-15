package cw.demo.pattern.struct.composite;

import java.util.List;

public class File implements Path {
    private String name;

    private Path dir;

    public File(String name) {
        this.name = name;
    }

    public File(String name, Path dir) {
        this.name = name;
        this.dir = dir;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void delete() {
        dir.deleteFile(this.name);
    }

    @Override
    public Path createFile(String name) {
        throw new RuntimeException("不支持的操作");
    }

    @Override
    public void deleteFile(String name) {
        throw new RuntimeException("不支持的操作");
    }

    @Override
    public List<Path> getFiles() {
        throw new RuntimeException("不支持的操作");
    }
}
