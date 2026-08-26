package optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        String email = "henry@altimetrik.com";
        String email1 = null;

        // of, empty, ofNullable
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Optional<String> emailOptional = Optional.of(email);
        System.out.println(emailOptional);

        Optional<String> emailOptional2 = Optional.ofNullable(email1);
        System.out.println("Reached here");
        if(emailOptional2.isPresent())
            System.out.println(emailOptional2.get());
        else
            System.out.println(emailOptional2.orElse("default@altimetrik.com"));

        // orElseGet in Optional class
        String defaultOptional2 = emailOptional2.orElseGet(() ->"justdefault@altimetrik.com");
        System.out.println(defaultOptional2);

        // orElseThrow in Optional class
//        String email_is_not_valid = emailOptional2.orElseThrow(() -> new IllegalArgumentException("Email not exists"));
//        System.out.println(email_is_not_valid);

        // ifPresent
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyOptional11 = Optional.empty();
        gender.ifPresent((s) -> System.out.println("value is present"));
        emptyOptional11.ifPresent(s -> System.out.println("No value present"));


        // filter method in Optional class
        String result = " abc ";
        if(result !=null && result.contains("abc")) {
            System.out.println(result);
        }

        Optional<String> optionalStr = Optional.of(result);
        optionalStr.filter((s) -> s.contains("abc"))
                .ifPresent((res) -> System.out.println(res));

        // map() method in Optional provides a way to transform value in Optional from one type to another
        optionalStr.filter((s) -> s.contains("abc"))
                .map(String::trim)
                .ifPresent((res) -> System.out.println(res));

    }



}
