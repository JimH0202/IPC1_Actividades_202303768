package controlador;

import modelo.CalculadoraModelo;
import modelo.Usuario;
import vista.CalculadoraVista;

import javax.swing.*;
import java.awt.event.*;

public class CalculadoraControlador {
    private CalculadoraModelo modelo;
    private CalculadoraVista vista;
    private Usuario usuario;

    public CalculadoraControlador(CalculadoraModelo modelo, CalculadoraVista vista, Usuario usuario) {
        this.modelo = modelo;
        this.vista = vista;
        this.usuario = usuario;

        // Vincular botones con el listener
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(vista.getTxtA());
                    double b = Double.parseDouble(vista.getTxtB());
                    double resultado = 0;

                    Object src = e.getSource();
                    if (src == vista.getBtnSuma()) resultado = modelo.sumar(a, b);
                    else if (src == vista.getBtnResta()) resultado = modelo.restar(a, b);
                    else if (src == vista.getBtnMult()) resultado = modelo.multiplicar(a, b);
                    else if (src == vista.getBtnDiv()) resultado = modelo.dividir(a, b);
                    else if (src == vista.getBtnPot()) resultado = modelo.potencia(a, b);
                    else if (src == vista.getBtnRaiz()) resultado = modelo.raiz(a, b);

                    vista.setResultado(String.valueOf(resultado));
                } 
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista, "Debes ingresar números válidos.");
                } 
                catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(vista, ex.getMessage());
                }
            }
        };

        vista.getBtnSuma().addActionListener(listener);
        vista.getBtnResta().addActionListener(listener);
        vista.getBtnMult().addActionListener(listener);
        vista.getBtnDiv().addActionListener(listener);
        vista.getBtnPot().addActionListener(listener);
        vista.getBtnRaiz().addActionListener(listener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
            if (nombre == null || nombre.trim().isEmpty()) nombre = "Invitado";

            Usuario usuario = new Usuario(nombre);
            CalculadoraModelo modelo = new CalculadoraModelo();
            CalculadoraVista vista = new CalculadoraVista(usuario.getNombre());

            new CalculadoraControlador(modelo, vista, usuario);
        });
    }
}
