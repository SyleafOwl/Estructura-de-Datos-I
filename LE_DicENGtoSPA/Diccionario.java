public class Diccionario {
    private Nodo head;
    private int size;

    private static class Nodo {
        WordPair palabra;
        Nodo siguiente;

        Nodo(WordPair palabra) {
            this.palabra = palabra;
            this.siguiente = null;
        }

    }

    public Diccionario() {
        head = null;
        size = 0;
    }

    public void agregarPalabra(String ingles, String español) {
        WordPair nuevaPalabra = new WordPair(ingles, español);
        Nodo nuevoNodo = new Nodo(nuevaPalabra);

        if (head == null) {
            head = nuevoNodo;
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        size++;
    }

    public String buscarIngles(String palabra) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.palabra.getEnglish().equals(palabra.toLowerCase())) {
                return actual.palabra.getSpanish();
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public String buscarEspanol(String palabra) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.palabra.getSpanish().equals(palabra.toLowerCase())) {
                return actual.palabra.getEnglish();
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public String listarPalabras() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = head;
        sb.append("\n--- Diccionario Completo ---\n");
        while (actual != null) {
            sb.append(String.format("%s   |   %s\n", 
                actual.palabra.getEnglish().toUpperCase(), actual.palabra.getSpanish().toUpperCase()));
            actual = actual.siguiente;
        }
        sb.append("Total: ").append(size).append(" palabras\n");
        return sb.toString();
    }

    // Dentro de la clase Diccionario...

    /**
     * Elimina una palabra por su versión en inglés
     * Palabra en inglés a eliminar
     * return true si se eliminó, false si no se encontró
     */
    public boolean eliminarPorIngles(String palabra) {
        if (head == null) return false;
        
        // Caso especial: eliminar el primer nodo
        if (head.palabra.getEnglish().equals(palabra.toLowerCase())) {
            head = head.siguiente;
            size--;
            return true;
        }
        
        Nodo actual = head;
        while (actual.siguiente != null) {
            if (actual.siguiente.palabra.getEnglish().equals(palabra.toLowerCase())) {
                actual.siguiente = actual.siguiente.siguiente;
                size--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Elimina una palabra por su versión en español
     * Palabra en español a eliminar
     * return true si se eliminó, false si no se encontró
     */
    public boolean eliminarPorEspanol(String palabra) {
        if (head == null) return false;
        
        // Caso especial: eliminar el primer nodo
        if (head.palabra.getSpanish().equals(palabra.toLowerCase())) {
            head = head.siguiente;
            size--;
            return true;
        }
        
        Nodo actual = head;
        while (actual.siguiente != null) {
            if (actual.siguiente.palabra.getSpanish().equals(palabra.toLowerCase())) {
                actual.siguiente = actual.siguiente.siguiente;
                size--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public int getSize() {
        return size;
    }
}