package java_oca;

// Which code fragment would replace the if block ?

public class Ques31 {
    public static void main(String[] args) {
        String stuff = "TV";
        String res = null;

//        if(stuff.equals("TV")) {
//            res = "Waiter";
//        } else if (stuff.equals("Movie")) {
//            res = "White";
//        } else {
//            res = "No Result";
//        }

       // stuff.equals("TV") ? res ="Waiter" : stuff.equals("Movie") ? res ="White" : res="No Result";
       // res = stuff.equals("TV") : "Waiter" else stuff.equals("Movie")? "White" : "No Result";
       // res = stuff.equals("TV") ? stuff.equals("Movie")? "Waiter" : "White" : "No Result";

        res = stuff.equals("TV") ? "Waiter" : stuff.equals("Movie") ? "White" : "No Result";

        System.out.println(res);
    }
}
