import java.util.ArrayList;

public class StackList {
    private Node top;
    private int size = 0;

    public void push(String val) {
        Node n = new Node(val);
        n.next = top;
        top = n;
        size++;
    }

    public String pop() {
        if (top == null) throw new RuntimeException("Pila vacía");
        String val = top.value;
        top = top.next;
        size--;
        return val;
    }

    public String peek() {
        if (top == null) throw new RuntimeException("Pila vacía");
        return top.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public ArrayList toList() {
        ArrayList result = new ArrayList();
        Node current = top;
        while (current != null) {
            result.add(current.value);
            current = current.next;
        }
        return result;
    }
}