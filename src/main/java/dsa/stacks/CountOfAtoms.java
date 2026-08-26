package dsa.stacks;

import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

// Output should be : K4 Mg5 N2 O14 S4
public class CountOfAtoms {
    public static void main(String[] args) {
        String formula = "K4(ONMg2(SO)3)2)2(Mg)";
        String finalResult = countOfAtoms(formula);
        System.out.println(finalResult);
    }

    private static String countOfAtoms(String str) {
        int n = str.length();
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int index = 0;
        while(index<str.length()){
            char ch = str.charAt(index);
            if(ch == '(') {
                stack.push(new HashMap<>());
                index++;
            } else if(ch == ')') {
                HashMap<String, Integer> curMap = stack.pop();
                // find the multiplier
                StringBuilder multiplier = new StringBuilder();
                while(index<n && Character.isDigit(str.charAt(index))) {
                        multiplier.append(str.charAt(index));
                        index++;
                }
                if(multiplier.length() >0){
                    int m = Integer.parseInt(multiplier.toString());
                    for(String atom : curMap.keySet()) {
                        stack.peek().put(
                                atom,
                                stack.peek().getOrDefault(atom, 0) + curMap.get(atom)
                        );
                        curMap.put(atom, curMap.get(atom) * m);
                    }
                }
            } else {
                // Atom name and count
                // take the uppercase letter
                StringBuilder atomName = new StringBuilder();
                atomName.append(ch);
                index++;
                // collect all lowercase letters
                while(index < n  && Character.isLowerCase(str.charAt(index))) {
                    atomName.append(str.charAt(index));
                    index++;
                }

                StringBuilder count = new StringBuilder();
                while(index<n && Character.isDigit(str.charAt(index))) {
                    count.append(str.charAt(index));
                    index++;
                }

                int c = (count.length()>0) ? Integer.parseInt(count.toString()) : 1;
                stack.peek().put(
                        String.valueOf(atomName),
                        stack.peek().getOrDefault(String.valueOf(atomName), 0) + c
                );
            }

        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(stack.peek());
        StringBuilder res = new StringBuilder();
        for(String atom : sortedMap.keySet()) {
            res.append(atom);
            int count = sortedMap.get(atom);
            if(sortedMap.get(atom) > 1) {
                res.append(count);
            }
        }
        return res.toString();
    }
}


//public String countOfAtoms(String formula) {
//    int n = formula.length();
//    Stack<HashMap<String,Integer>> stack = new Stack<>();
//    stack.push(new HashMap<String,Integer>());
//    int index=0;
//    // O(N) + O(K)
//    //O(N)*(N)
//    while(index<n){
//        char ch = formula.charAt(index);
//        if(ch == '('){
//            stack.push(new HashMap<String,Integer>());
//            index++;
//        }else if(ch == ')'){
//            HashMap<String,Integer> curMap = stack.pop();
//            index++; //move to the next char
//            //find the multiplier
//            StringBuilder multiplier = new StringBuilder();
//            while(index < n && Character.isDigit(formula.charAt(index))){
//                multiplier.append(formula.charAt(index));
//                index++;
//            }
//            //multiply the count - ()n
//            if(multiplier.length()>0){
//                int m = Integer.parseInt(multiplier.toString());
//                for(String atom : curMap.keySet()){
//                    curMap.put(atom, curMap.get(atom) * m);
//                }
//            }
//            //insert popped map elements into stack top
//            for(String atom : curMap.keySet()){
//                stack.peek().put(
//                        atom,
//                        stack.peek().getOrDefault(atom,0)+curMap.get(atom)
//                );
//            }
//
//        }else{ //Atom name and count
//            // take the uppercase letter
//            StringBuilder atomName = new StringBuilder();
//            atomName.append(ch);
//            index++;
//            //collect all lowercase letters
//            while(index < n && Character.isLowerCase(formula.charAt(index))){
//                atomName.append(formula.charAt(index));
//                index++;
//            }
//            StringBuilder count = new StringBuilder();
//            while(index < n && Character.isDigit(formula.charAt(index))){
//                count.append(formula.charAt(index));
//                index++;
//            }
//            int c = (count.length()>0)?Integer.parseInt(count.toString()):1;
//            stack.peek().put(
//                    atomName.toString(),
//                    stack.peek().getOrDefault(atomName.toString(),0)+c
//            );
//        }
//    }
//    // 2K
//    TreeMap<String,Integer> sortedMap = new TreeMap<>(stack.peek());
//    StringBuilder res = new StringBuilder();
//    for(String atom : sortedMap.keySet()){
//        res.append(atom);
//        int count = sortedMap.get(atom);
//        if(count>1){
//            res.append(count);
//        }
//    }
//    return res.toString();
//}