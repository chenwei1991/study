package cw.demo.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileNIO {
    public static void main(String[] args) throws IOException {
        String inFile = "D:/1.txt";
        String outFile = "D:/2.txt";

        FileInputStream fin = new FileInputStream(inFile);
        FileChannel finc = fin.getChannel();

        FileOutputStream fout = new FileOutputStream(outFile);
        FileChannel foutc = fout.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            int r = finc.read(byteBuffer);
            if (r == -1) {
                break;
            }
            byteBuffer.flip();
            foutc.write(byteBuffer);
        }
    }
}
