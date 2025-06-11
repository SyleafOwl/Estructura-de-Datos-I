public class NodoSongDouble {
    String name;
    NodoSongDouble next;
    NodoSongDouble previous; 

    public NodoSongDouble(String name) {
        this.name = name;
        this.next = null;
        this.previous = null; 
    }
}