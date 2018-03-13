package cw.demo.pattern.create.prototype;

public class Client {


    public static void main(String[] args) {
        Money money = new Money("中国", 100);
        money.show();
        Money clone = (Money) money.clone();
        clone.show();

        System.out.println(money.equals(clone));
    }
}
