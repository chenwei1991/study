package cw.demo.pattern.action.mediator;

public class Client {
    public static void main(String[] args) {
        /*
        通过一个中介者（ChatRoom）来负责不同对象（User）之间联系，解决一系列对象之间复杂的耦合关系，这一系列对象往往是“多对多”的耦合关系，中介者模式采用一个中介者对象将这一系列对象集中管理，而各个对象也将自己与其它对象的交互行为委托给中介者处理，从而减少这一系列对象之间的耦合。
         */
        ChatRoom room = new ChatRoom();
        User zs = new User("张三");
        User ls = new User("李四");
        User ww = new User("王五");

        zs.join(room);
        ls.join(room);
        ww.join(room);

        zs.sendAll("hello");

        ls.exit();
        ls.sendAll("你好");

        ww.sendAll("尼玛");

    }
}
