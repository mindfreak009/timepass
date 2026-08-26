package dsa.stacks.customstack;

public class DynamicStack extends CustomStack {

    public boolean push(int item) {
        // this takes care of being full
        if(this.isFull()) {
            // double the array size
            int[] temp = new int[data.length * 2];

            // copy all the previous items in data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }

        // at this point, we know that the array is NOT FULL
        return super.push(item);
    }
}
