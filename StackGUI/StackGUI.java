import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class StackGUI extends JFrame {

    private final StackList stack = new StackList();
    private final DefaultListModel model = new DefaultListModel();
    private final JList list = new JList(model);
    private final JTextField input = new JTextField();

    public StackGUI() {
        super("Pila con GUI ULIMA");

        setLayout(new BorderLayout(10, 10));
        list.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        add(new JScrollPane(list), BorderLayout.CENTER);

        JPanel controls = new JPanel(new GridLayout(2, 1, 5, 5));

        JPanel line1 = new JPanel(new BorderLayout(5, 5));
        line1.add(new JLabel("Valor a push:"), BorderLayout.WEST);
        line1.add(input, BorderLayout.CENTER);
        JButton pushBtn = new JButton("Push (Empilar)");
        line1.add(pushBtn, BorderLayout.EAST);

        JPanel line2 = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton popBtn = new JButton("Pop (Desempilar)");
        JButton peekBtn = new JButton("Peek");
        JButton sizeBtn = new JButton("Size");
        JButton clearBtn = new JButton("Clear");
        line2.add(popBtn);
        line2.add(peekBtn);
        line2.add(sizeBtn);
        line2.add(clearBtn);

        controls.add(line1);
        controls.add(line2);
        add(controls, BorderLayout.SOUTH);

        pushBtn.addActionListener(e -> {
            String val = input.getText().trim();
            if (!val.isEmpty()) {
                stack.push(val);
                input.setText("");
                refreshView();  
                System.out.println("Valor: " + val);
            }
        });

        popBtn.addActionListener(e -> performSafe(() -> {
            String v = stack.pop();
            JOptionPane.showMessageDialog(this, "Pop (Desempilar): " + v);
            refreshView();
        }));
/*
        peekBtn.addActionListener(e -> performSafe(() -> {
            //String v = stack.peek();
           // JOptionPane.showMessageDialog(this, "Peek (cima): " + v);
        }));

        sizeBtn.addActionListener(e ->
           // JOptionPane.showMessageDialog(this, "Tamaño actual: " + stack.size())
        );

        clearBtn.addActionListener(e -> {
          //  while (!stack.isEmpty()) stack.pop();
            refreshView();
        });
*/
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void refreshView() {
        model.clear();
        ArrayList elementos = stack.toList();
        for (int i = 0; i < elementos.size(); i++) {
            model.addElement(elementos.get(i));
        }
    }

    private void performSafe(Runnable r) {
        try {
            r.run();
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new StackGUI());
    }
}