public class NodoSongDouble {
    String name;
    String filePath;
    NodoSongDouble next;
    NodoSongDouble previous; 

    public NodoSongDouble(String name) {
        this.name = name;
        this.filePath = null; 
        this.next = null;
        this.previous = null; 
    }
}