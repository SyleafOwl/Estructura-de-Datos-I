public static void main(String[] args) {
    ListaEnlazada lista = new ListaEnlazada();
        
    System.out.println("hay datos? " + lista.estaVacia());  // true
        
    lista.insertarAlInicio(10);
    lista.insertarAlInicio(20);
    lista.insertarAlFinal(30);
        
    lista.mostrar();  // 20 -> 10 -> 30 -> null
        
    System.out.println("Tamaño: " + lista.getSize());  // 3
    System.out.println("existe 10? " + lista.buscar(10));  // true
       
}