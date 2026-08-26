package designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class MyIteratorImpl implements  MyIterator {

    private List<User> userList;
    private int length;
    private int position = 0;

    public MyIteratorImpl(List<User> userList) {
        this.userList = userList;
        this.length = userList.size();
    }

    @Override
    public boolean hasNext() {
        if(position >= length)
            return false;
        else
            return true;
    }

    @Override
    public Object next() {
        User user = userList.get(position);
        position += 1;
        return user;
    }
}
