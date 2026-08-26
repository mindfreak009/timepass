package interviewtime;

class LL {
    Object data;
    Object head;
    Object tail;
    LL node;
    int next;

    public LL(Object data, LL node, int next) {
        this.data = data;
        this.node = node;
        this.next = next;
    }

    public Object getData() {
       return data;
    }

    public void setData(Object data) {

        if(head == null & tail == null) {
            this.data = data;
        }

        if(head == null) {
            this.data = data;
            this.data = next;
        }

        if(data == null) {
            this.data = null;
        }
        this.data = data;
    }

    public LL getNode() {
        if(node == null) {

        }
        return node;
    }

    public void setNode(LL node) {
        this.node = node;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}

public class SingleLinkedList {
    public static void main(String[] args) {

    }
}
