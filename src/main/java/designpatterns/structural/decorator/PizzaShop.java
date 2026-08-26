package designpatterns.structural.decorator;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        pizza.bake();

        Pizza pizza1 = new CheesePizzaDecorator(new PlainPizza());
        pizza1.bake();

        Pizza pizza2 = new VeggiePizzaDecorator(new PlainPizza());
        pizza2.bake();

    }
}
