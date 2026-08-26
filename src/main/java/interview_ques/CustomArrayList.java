package interview_ques;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomArrayList extends ArrayList {
    @Override
    public boolean add(Object o) {
        if(this.contains(o)) {
            return false ;
        }
        return super.add(o);
    }

    public static void main(String[] args) {
        CustomArrayList arrayList = new CustomArrayList();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);

        System.out.println(arrayList);
    }

}
