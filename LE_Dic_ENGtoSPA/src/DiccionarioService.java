import java.util.Scanner;

public class DiccionarioService {
    private Diccionario diccionario;
    private Scanner scanner;

    public DiccionarioService() {
        this.diccionario = new Diccionario();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            mostrarMenu();
            int opcion = Integer.parseInt(scanner.nextLine());
            
            switch (opcion) {
                case 1:
                    traducirInglesEspanol();
                    break;
                case 2:
                    traducirEspanolIngles();
                    break;
                case 3:
                    System.out.println(diccionario.listarPalabras());
                    break;
                case 4:
                    eliminarPalabra();
                    break;
                case 5:
                    System.out.println("¡Hasta pronto!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida\n");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n=== Diccionario Inglés-Español ===");
        System.out.println("1. Inglés a Español");
        System.out.println("2. Español a Inglés");
        System.out.println("3. Listas de palabras");
        System.out.println("4. Eliminar palabra");
        System.out.println("5. Salir");
        System.out.println("");
        System.out.print("Seleccione: ");
    }

    private void traducirInglesEspanol() {
        System.out.print("\nPalabra en inglés: ");
        String palabra = scanner.nextLine();
        String traduccion = diccionario.buscarIngles(palabra);

        if (traduccion != null) {
            System.out.printf("Traducción: %s es %s\n", palabra, traduccion.toUpperCase());
        } else {
            System.out.printf("'%s' no encontrada. ¿Agregar? (s/n): ", palabra);
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                agregarPalabra(palabra, true);
            }
        }
    }

    private void traducirEspanolIngles() {
        System.out.print("\nPalabra en español: ");
        String palabra = scanner.nextLine();
        String traduccion = diccionario.buscarEspanol(palabra);

        if (traduccion != null) {
            System.out.printf("Traducción: %s es %s\n", palabra, traduccion.toUpperCase());
        } else {
            System.out.printf("'%s' no encontrada. ¿Agregar? (s/n): ", palabra);
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                agregarPalabra(palabra, false);
            }
        }
    }

    private void agregarPalabra(String palabra, boolean esIngles) {
        if (esIngles) {
            System.out.print("Traducción al español: ");
            String español = scanner.nextLine();
            diccionario.agregarPalabra(palabra, español);
        } else {
            System.out.print("Traducción al inglés: ");
            String ingles = scanner.nextLine();
            diccionario.agregarPalabra(ingles, palabra);
        }
        System.out.println("¡Palabra agregada!");
    }
    private void eliminarPalabra() {
        System.out.println("\nEliminar por:");
        System.out.println("1. Inglés");
        System.out.println("2. Español");
        System.out.print("Seleccione opción: ");
        
        int opcion = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese la palabra a eliminar: ");
        String palabra = scanner.nextLine();
        
        boolean eliminado = false;
        switch(opcion) {
            case 1:
                eliminado = diccionario.eliminarPorIngles(palabra);
                break;
            case 2:
                eliminado = diccionario.eliminarPorEspanol(palabra);
                break;
            default:
                System.out.println("Opción no válida");
                return;
        }
        
        if (eliminado) {
            System.out.println("Palabra eliminada correctamente");
        } else {
            System.out.println("La palabra no existe en el diccionario");
        }
    }
    
}