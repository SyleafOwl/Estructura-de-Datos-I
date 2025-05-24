public class ListaPersona {
    NodoPersona head;
    int size;

    public ListaPersona() {
        this.head = null;
        this.size = 0;
    }
    
    public void adicionarPersonaInicio(Persona persona){
        NodoPersona nuevoNodo = new NodoPersona(persona);

        if (head == null) {
            head = nuevoNodo;            
        }else{
            head.prev = nuevoNodo;
            nuevoNodo.next = head;
            head = nuevoNodo;
        }
        size++;
    }

    public void adicionarPersonaFinal(Persona persona){
        NodoPersona nuevoNodo = new NodoPersona(persona);

        if (head == null) {
            head = nuevoNodo;
        }else{
            NodoPersona actual = head;
            while (actual.next != null) {
                actual = actual.next;                
            }
            actual.next = nuevoNodo;
        }
        size++;
    }

    public String mostrar(){
        NodoPersona actual = head;
        String cadena = "";
        while (actual != null) {
            cadena += actual.toString();
            actual = actual.next;
        }
        return cadena;
    }

    public Persona obtenerPersona(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    
        NodoPersona actual = head;
        int contador = 0;
    
        while (actual != null) {
            if (contador == indice) {
                return actual.persona; // Devuelve la persona en el nodo actual
            }
            actual = actual.next;
            contador++;
        }
    
        return null; // Esto no debería ocurrir si el índice es válido
    }

}
