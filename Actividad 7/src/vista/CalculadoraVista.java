package vista;

import java.awt.*;
import javax.swing.*;

public class CalculadoraVista extends JFrame {
    private JTextField txtA = new JTextField(10);
    private JTextField txtB = new JTextField(10);
    private JTextField txtResultado = new JTextField(15);

    private JButton btnSuma = new JButton("Suma");
    private JButton btnResta = new JButton("Resta");
    private JButton btnMult = new JButton("Multiplicación");
    private JButton btnDiv = new JButton("División");
    private JButton btnPot = new JButton("Potencia");
    private JButton btnRaiz = new JButton("Raíz");

    public CalculadoraVista(String usuario) {
        super("Calculadora - Usuario: " + usuario);
        setLayout(new BorderLayout());

        JPanel panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("A:"));
        panelEntrada.add(txtA);
        panelEntrada.add(new JLabel("B:"));
        panelEntrada.add(txtB);

        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 5, 5));
        panelBotones.add(btnSuma);
        panelBotones.add(btnResta);
        panelBotones.add(btnMult);
        panelBotones.add(btnDiv);
        panelBotones.add(btnPot);
        panelBotones.add(btnRaiz);

        JPanel panelResultado = new JPanel();
        txtResultado.setEditable(false);
        panelResultado.add(new JLabel("Resultado:"));
        panelResultado.add(txtResultado);

        add(panelEntrada, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(panelResultado, BorderLayout.SOUTH);

        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Getters para acceder desde el controlador
    public String getTxtA() { return txtA.getText(); }
    public String getTxtB() { return txtB.getText(); }
    public void setResultado(String res) { txtResultado.setText(res); }

    public JButton getBtnSuma() { return btnSuma; }
    public JButton getBtnResta() { return btnResta; }
    public JButton getBtnMult() { return btnMult; }
    public JButton getBtnDiv() { return btnDiv; }
    public JButton getBtnPot() { return btnPot; }
    public JButton getBtnRaiz() { return btnRaiz; }
}
