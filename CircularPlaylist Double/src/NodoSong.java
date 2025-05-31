public class NodoSong {
    String name;
    NodoSong next;
    NodoSong previous; // Added for double linked list functionality

    public NodoSong(String name) {
        this.name = name;
        this.next = null;
        this.previous = null; // Initialize previous to null
    }
}