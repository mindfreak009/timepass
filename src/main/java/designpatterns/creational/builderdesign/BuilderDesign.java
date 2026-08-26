package designpatterns.creational.builderdesign;

// The Builder Design Pattern helps us to slice the operations of building an object.
// It focuses on constructing a complex object step by step.

// The key difference between a builder and factory IMHO, is that a builder is useful when you need to do lots of things to build an object.

public class BuilderDesign {
    public static void main(String[] args) {
       User user =  new User.UserBuilder()
                            .setUserId("mindfreak")
                            .setUserName("Altimetrik")
                            .setEmailId("ppangeni@altimetrik.com").build();

        System.out.println("userbuilder :::: " +user);

        User user2 =  new User.UserBuilder().builder()
                .setUserId("helloworld")
                .setUserName("Altimetrik")
                .build();

        System.out.println("userbuilder2 :::: " +user2);

    }
}
