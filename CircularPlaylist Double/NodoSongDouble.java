public class NodoSongDouble {
    String name;
    NodoSongDouble next;
    NodoSongDouble previous; // Added for double linked list functionality

    public NodoSongDouble(String name) {
        this.name = name;
        this.next = null;
        this.previous = null; // Initialize previous to null
    }
}