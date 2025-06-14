public class CircularListDouble {
    NodoSongDouble head;
    NodoSongDouble current;
    int size;

    public CircularListDouble() {
        head = null;
        current = null;
        size = 0;
        
    }

    public void add(String name) {
        NodoSongDouble newNode = new NodoSongDouble(name);
        if (head == null) {
            head = newNode;
            current = head;
            head.next = head; 
            head.previous = head; 
        } else {
            NodoSongDouble temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode; // Enlace al nuevo nodo
            newNode.previous = temp; // Enlace al nodo anterior
            newNode.next = head; // Enlace al head para continuar lo circular
            head.previous = newNode; // Actualiza lo anterior del head
        }
        size++;
    }

    public String nextSong() {
        if (current == null) {
            return ""; 
        }
        current = current.next; // Mueve directamente al nodo siguiente
        return current.name; // Retorna el nombre de la canción en el nodo actual.
    }

    public String previousSong() {
        if (current == null) {
            return ""; 
        }
        current = current.previous; // Mueve directamente al nodo anterior
        return current.name; // Retorna el nombre de la canción en el nodo actual.
    }

    public String getCurrentSong() {
        return current.name;
    }

    public boolean isEmpty() {
        return false;
    }
}