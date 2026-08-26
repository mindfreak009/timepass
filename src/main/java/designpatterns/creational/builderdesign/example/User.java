package designpatterns.creational.builderdesign.example;

public class User {
    private final String userName;
    private final String email;
    private final int age ;
    private final String city;

    private User(Builder builder) {
        this.userName = builder.userName;
        this.email = builder.email;
        this.age = builder.age;
        this.city = builder.city;
    }

    public static class Builder {
        private String userName;
        private String email;
        private int age ;
        private String city;

        public Builder(String userName, String email) {
            this.userName = userName;
            this.email = email;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public User build() {
            return new User(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "userName='" + userName + '\'' +
                    ", email='" + email + '\'' +
                    ", age=" + age +
                    ", city='" + city + '\'' +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
