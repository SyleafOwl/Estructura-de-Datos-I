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

}
