package interview_ques.servicebased.calsoft;

// You are in superstore and purchase items of costs [80, 120, 150].   // 80 + 108 + 135 = 323
// What is final bill provided that superstore provides 10% off on purchase of item with cost >= 100 ?

import java.util.Arrays;

// Use stream API.
public class PurchaseWith10PercentDiscountForAllItemsAbove100 {
    public static void main(String[] args) {
        int[] itemCost = {80, 120, 150};
        System.out.println(purchaseItemWith10PercentDiscount(itemCost));
    }

    public static int purchaseItemWith10PercentDiscount(int[] itemCost) {
        return Arrays.stream(itemCost)
                .map(x -> {
                    if(x >= 100)
                       return x - x/10;
                    else return x;
                }).sum();
    }
}
