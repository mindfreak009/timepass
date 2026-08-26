package durgasoft_java.java8.predicate;

import java.util.Scanner;
import java.util.function.Predicate;

class User {
    private String userName;
    private String pwd;

    public User(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "userName='" + userName + '\'' +
//                ", pwd='" + pwd + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", userName, pwd);
    }
}


public class PredicateWithUserAuthentication {

    public static void main(String[] args) {
        Predicate<User> userPredicate = user -> user.getUserName()
                .equals("prakash") &&
                user.getPwd().equals("hello123");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter user name :: ");
        String userName = scan.next();

        System.out.println("Enter password");
        String pwd = scan.next();

        User user = new User(userName, pwd);
        System.out.println("User details ::" + user);
        if (userPredicate.test(user)) {
            System.out.println("Welcome !!");
        } else {
            System.out.println("INVALID ");
        }


    }

}
