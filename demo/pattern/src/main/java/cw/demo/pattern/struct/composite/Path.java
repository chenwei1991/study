package cw.demo.pattern.struct.composite;

import java.util.List;

public interface Path {

    String getName();

    void delete();

    default boolean isFile() {
        return getName().contains(".");
    }

    /*
    在组合模式中，安全性和透明性是互相矛盾的，这是由于叶子节点和非叶子节点行为的不一致以及需要提供一个一致的行为接口所造成的，是不可调和的矛盾。
    不一致的接口（文件夹独有
     */

    Path createFile(String name);

    void deleteFile(String name);

    List<Path> getFiles();


}
