public class ListaEnlazada {
    private Nodo head;  // Apunta al primer nodo de la lista
    private int size;   // Cantidad de elementos en la lista

    // Constructor
    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return head == null;  // Equivalente a size == 0
    }

    // Retorna el tamaño actual de la lista
    public int getSize() {
        return size;
    }

    // ========== OPERACIONES PRINCIPALES ========== //

    /**
     * Inserta un nuevo elemento al INICIO de la lista
     * 1. Crea un nuevo nodo con el dato
     * 2. El nuevo nodo apunta al actual head
     * 3. Head ahora apunta al nuevo nodo
     * 4. Incrementa size
     */
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = head;
        head = nuevoNodo;
        size++;
    }

    // Inserta al final de la lista
    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        
        if (estaVacia()) {
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

    // Busca un elemento en la lista
    public boolean buscar(int dato) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.dato == dato) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Muestra la lista completa
    public void mostrar() {
        Nodo actual = head;
        System.out.print("Lista (" + size + " elementos): ");
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

}