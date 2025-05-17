public class MainListas {
public static void main(String[] args) {
    ListaEnlazada lista = new ListaEnlazada();
        
    System.out.println("hay datos? " + lista.estaVacia());  // true
        
    lista.insertarAlInicio(10);
    lista.insertarAlInicio(20);
    lista.insertarAlFinal(30);
        
    lista.mostrar();  // 20 -> 10 -> 30 -> null
        
    System.out.println("Tamaño: " + lista.getSize());  // 3
    System.out.println("existe 10? " + lista.buscar(10));  // true
    
    lista.eliminarAlInicio();
    lista.mostrar();  // Lista (2 elementos): 20 -> 30 -> null
    
    lista.eliminarAlFinal();
    lista.mostrar();  // Lista (1 elementos): 20 -> null
    
    lista.eliminarElemento(20);
    lista.mostrar();  // Lista (0 elementos): null
}
}