package designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {

    private List<User> userList = new ArrayList<>() ;

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUser(int index) {
        return userList.get(index);
    }

    public MyIterator getIterator() {
        return new MyIteratorImpl(userList);
    }
}

