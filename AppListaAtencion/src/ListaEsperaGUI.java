import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListaEsperaGUI extends JFrame {
    private DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private JList<String> jList = new JList<>(modeloLista);

    public ListaEsperaGUI() {
        super("Lista de Espera");
        ListaPersona Lista = new ListaPersona();

        JTextField nombreField = new JTextField(15);
        JTextField edadField = new JTextField(3);
        JButton agregarBtn = new JButton("Agregar");

        agregarBtn.addActionListener(e -> {
            String nombre = nombreField.getText().trim();
            String edadTexto = edadField.getText().trim();
            if (!nombre.isEmpty() && !edadTexto.isEmpty()) {
                try {
                    int edad = Integer.parseInt(edadTexto);
                    Persona persona = new Persona(nombre, edad);
        
                    // Agregar la persona con prioridad
                    if (edad >= 65) {
                        Lista.adicionarPersonaInicio(persona); // Alta prioridad: agregar al inicio
                    } else {
                        Lista.adicionarPersonaFinal(persona); // Baja prioridad: agregar al final
                    }
        
                    // Limpiar los campos de texto
                    nombreField.setText("");
                    edadField.setText("");
        
                    // Actualizar el modelo de la JList
                    modeloLista.clear(); // Limpia el modelo actual
                    NodoPersona actual = Lista.head; // Recorre la lista desde el inicio
                    while (actual != null) {
                        modeloLista.addElement(actual.persona.toString()); // Agrega cada persona al modelo
                        actual = actual.next;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Edad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JPanel formPanel = new JPanel();
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nombreField);
        formPanel.add(new JLabel("Edad:"));
        formPanel.add(edadField);
        formPanel.add(agregarBtn);

        this.setLayout(new BorderLayout());
        this.add(formPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(jList), BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListaEsperaGUI());
    }
}