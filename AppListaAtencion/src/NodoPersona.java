class NodoPersona{
    Persona persona;
    Nodo next;
    Nodo prev;

    public NodoPersona(Persona persona) {
        this.persona = persona;
        this.next = null;
        this.prev = null;
    }

    public NodoPersona() {
        this.next = null;
        this.prev = null;
    }    

}
