package designpatterns.creational.builderdesign.example;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder("vipin", "vipin@example.com")
                .age(30)
                .city("Pune")
                .build();

        System.out.println(user);
    }
}
