package interview_ques.servicebased.relevantz;

import java.util.*;

// Question:
// You have a large list of users and orders. Find all orders belonging to each user efficiently.
// Avoid nested loops.

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Order {
    int orderId;
    int userId;
    String product;

    Order(int orderId, int userId, String product) {
        this.orderId = orderId;
        this.userId = userId;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId +
                ", product='" + product + "'}";
    }
}


public class UserOrderMapping {

    public static Map<Integer, List<Order>> getOrdersByUser(
            List<User> users,
            List<Order> orders) {

        // Step 1: Create an index of orders by userId
        Map<Integer, List<Order>> ordersByUser = new HashMap<>();

        for (Order order : orders) {
            ordersByUser
                    .computeIfAbsent(order.userId, k -> new ArrayList<>())
                    .add(order);
        }

        // Step 2: Find orders for each user
        Map<Integer, List<Order>> result = new HashMap<>();

        for (User user : users) {
            result.put(
                    user.id,
                    ordersByUser.getOrDefault(user.id, Collections.emptyList())
            );
        }

        return result;
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Alice"),
                new User(2, "Bob"),
                new User(3, "Charlie")
        );

        List<Order> orders = List.of(
                new Order(101, 1, "Laptop"),
                new Order(102, 2, "Phone"),
                new Order(103, 1, "Mouse"),
                new Order(104, 3, "Keyboard"),
                new Order(105, 1, "Monitor")
        );

        Map<Integer, List<Order>> ordersByUser =
                UserOrderMapping.getOrdersByUser(users, orders);

        ordersByUser.forEach((userId, userOrders) ->
                System.out.println(
                        "User ID: " + userId +
                                ", Orders: " + userOrders
                )
        );
    }
}
