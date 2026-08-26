package java_oca;

// Output:
// 400.0 : 100.0


class Product {
  double price;
}

public class Ques1 {
    public void updatePrice (Product product, double price) {
        price = price * 2;
        System.out.println("price here :: "+price);
        product.price = product.price + price;
        System.out.println("product.price here :: " +product.price);
    }

    public static void main(String[] args) {
        Product prt = new Product();
        prt.price = 200;
        double newPrice = 100;

        Ques1 t = new Ques1();
        System.out.println("prt :: " +prt + " newPrice : "+newPrice);
        t.updatePrice(prt, newPrice);
        System.out.println(prt.price + " : "  + newPrice);

    }

}
