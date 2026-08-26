package designpatterns.behavioral.iterator;

// Iterator pattern provides way to access elements of an object without exposing its underlying implementation.

public class IteratorDesignMain {
    public static void main(String[] args) {

        UserManagement userManagement = new UserManagement();
        userManagement.addUser(new User("HelloWorld", "14"));
        userManagement.addUser(new User("MyWorld", "15"));
        userManagement.addUser(new User("TheirWorld", "16"));
        userManagement.addUser(new User("DellWorld", "17"));

        MyIterator iterator = userManagement.getIterator();
        while(iterator.hasNext()) {
            User user = (User) iterator.next();
            System.out.println(user.getName());
        }
       //  System.out.println(userManagement);

    }
}
