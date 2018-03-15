package cw.demo.pattern.action.mediator;

public class User {
    public String getName() {
        return name;
    }

    private String name;
    private ChatRoom chatRoom;

    public User(String name) {
        this.name = name;
    }

    public void join(ChatRoom room) {
        this.chatRoom = room;
        chatRoom.add(this);
        System.out.println(this.name + "加入聊天室");
    }

    public void exit() {
        if (this.chatRoom != null) {
            this.chatRoom.remove(this);
            this.chatRoom = null;
        }
        System.out.println(this.name + "退出聊天室");
    }

    public void sendAll(String msg) {
        if (this.chatRoom == null) {
            System.out.println(this.name + "不在聊天室，不能发消息");
            return;
        }
        this.chatRoom.sendAll(this, msg);
    }


    public void receive(String fromUserName, String message) {
        System.out.println(this.getName() + "收到" + fromUserName + "发来的消息：" + message);
    }
}
