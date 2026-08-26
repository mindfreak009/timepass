package dsa.queue.circularqueue;

public class DynamicQueue extends CircularQueue{
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        // this takes care of it being full
        if(this.isFull()) {
            // double the array size
            int[] temp = new int[data.length * 2];

            // copy all previous items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front +i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
            return false;
        }

        // at this point, we know that array is NOT full
        // insert item
        return super.insert(item);
    }

}
