package cw.demo.pattern.struct.bridge;

public class NoteBook extends Computer {


    public NoteBook(Brand brand) {
        super(brand);
    }

    @Override
    public void run() {
        super.brand.show();
        System.out.println("笔记本运行");
    }
}
