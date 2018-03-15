package cw.demo.pattern.struct.bridge;

public class Pad extends Computer {
    public Pad(Brand brand) {
        super(brand);
    }

    @Override
    public void run() {
        super.brand.show();
        System.out.println("平板运行");
    }
}
