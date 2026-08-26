package designpatterns.behavioral.iterator;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private String name;
    private String userId;

    public User() {}

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }


//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", userId='" + userId + '\'' +
//                '}';
//    }
}
