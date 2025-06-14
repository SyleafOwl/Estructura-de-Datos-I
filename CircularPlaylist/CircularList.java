public class CircularList {
    NodoSong head;
    NodoSong current;
    int size;

    public CircularList() {
        head = null;
        current = null;
        size = 0;
    }

    public void add(String name) {
        NodoSong newNode = new NodoSong(name);
        if (head == null) {
            head = newNode;
            current = head;
            head.next = head; // Circular link
        } else {
            NodoSong temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode; // Link the last node to the new node
            newNode.next = head;
        }
        size++;
    }

    public String nextSong() {
        if (current == null) {
            return "";
        }
        String songName = current.name;
        current = current.next; // Move to the next song
        return songName;
    }

    public String getCurrentSong() {
        return "";
    }

    public boolean isEmpty() {
        return false;
    }
}