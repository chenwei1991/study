package cw.demo.pattern.action.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<User> userList = new ArrayList<User>();


    public void add(User user) {
        userList.add(user);
    }

    public void remove(User user) {
        userList.remove(user);
    }

    public void sendAll(User user, String message) {
        userList.stream().filter(t -> !t.equals(user)).forEach(t -> {
            t.receive(user.getName(), message);
        });
    }
}
