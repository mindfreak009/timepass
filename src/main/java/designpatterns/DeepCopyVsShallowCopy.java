package designpatterns;

import java.util.ArrayList;

// Shallow Copy stores the references of objects to the original memory address.
// Shallow Copy reflects changes made to the new/copied object in the original object.
// A shallow copy is faster.

// Deep copy stores copies of the object's value.
// Deep copy doesn't reflect changes made to the new/copied object in the original object.
// A deep copy is slower.

public class DeepCopyVsShallowCopy {
    public String name;
    public ArrayList<String> colors;

    public DeepCopyVsShallowCopy(String name, ArrayList<String> colors) {
        this.name = name;
        this.colors = colors;
    }

    public static void main(String[] args) {
        // Create a Honda car object
        ArrayList<String> hondaColors = new ArrayList<>();
        hondaColors.add("Red");
        hondaColors.add("Blue");
        DeepCopyVsShallowCopy honda = new DeepCopyVsShallowCopy("Honda", hondaColors);

        // Deep copy of Honda
        DeepCopyVsShallowCopy deepcopyHonda = new DeepCopyVsShallowCopy(
                honda.name, new ArrayList<>(honda.colors));
        deepcopyHonda.colors.add("Green");

        System.out.print("Deepcopy: ");
        for (String color : deepcopyHonda.colors) {
            System.out.print(color + " ");
        }

        System.out.println("\nOriginal: ");
        System.out.println("----------");
        for (String color : honda.colors) {
            System.out.print(color + " ");
        }
        System.out.println();
        System.out.println("================================");


        // Shallow Copy of Honda
        DeepCopyVsShallowCopy copyHonda = honda;
        copyHonda.colors.add("Green");

        System.out.print("Shallow Copy: ");
        for(String color: copyHonda.colors) {
            System.out.print(color + " ");
        }

        System.out.println("\n Original");
        System.out.println("-------------");
        for (String color : honda.colors){
            System.out.print(color + " ");
        }
    }
}
