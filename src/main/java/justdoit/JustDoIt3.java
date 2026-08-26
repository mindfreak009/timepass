package justdoit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JustDoIt3 {


    private  String checkoutId;
    private  String cardBrand; //MASTERCARD, VISA, DISCOVER, AMEX
    private  String actionType; //ADD, UPDATE, DELETE
    private  String cardType; //CREDIT, DEBIT

    public JustDoIt3(String checkoutId, String cardBrand, String actionType, String cardType) {
        this.checkoutId = checkoutId;
        this.cardBrand = cardBrand;
        this.actionType = actionType;
        this.cardType = cardType;
    }




    public static void main(String[] args) {

        JustDoIt3 merch1 = new JustDoIt3("abc-3432-23747-dshfds" ,"MASTERCARD", "ADD", "CREDIT");
        JustDoIt3 merch2 = new JustDoIt3("abc-3432-23747-dshf423" ,"MASTERCARD", "ADD", "CREDIT");
        JustDoIt3 merch3 = new JustDoIt3("abc-3432-23747-dshf424" ,"VISA", "ADD", "CREDIT");

        List<JustDoIt3> merchantDtls = new ArrayList<>();
        merchantDtls.add(merch1);
        merchantDtls.add(merch2);
        merchantDtls.add(merch3);

        Map<String, Long> m =  merchantDtls.stream().map(e -> e.cardBrand + "-" +e.actionType + "-" +e.cardType)
                .distinct()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        m.entrySet().stream().forEach(System.out::println);

    }
}
