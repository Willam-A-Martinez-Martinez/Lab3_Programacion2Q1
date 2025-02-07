/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_programacion2q1;

/**
 Nadiesda trabajo en esta clase pero tuvo problemas con github
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sudokus_menu extends JFrame {
    private JButton btnIniciarJuego;
    private JButton btnSalir;

    public Sudokus_menu() {
        setTitle("Menú Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));
        getContentPane().setBackground(new Color(173, 216, 230)); // Azul claro
        
        JLabel lblTitulo = new JLabel("MENÚ PRINCIPAL", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.BLUE);
        add(lblTitulo);
        
        btnIniciarJuego = new JButton("Iniciar Juego");
        btnSalir = new JButton("Salir");
        
        btnIniciarJuego.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        btnIniciarJuego.setBackground(new Color(100, 149, 237)); // Azul medio
        btnSalir.setBackground(new Color(70, 130, 180)); // Azul acero
        
        btnIniciarJuego.setForeground(Color.WHITE);
        btnSalir.setForeground(Color.WHITE);
        
        add(btnIniciarJuego);
        add(btnSalir);
        
    
        btnIniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JuegoFrame(); 
                dispose(); 
            }
        });
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new Sudokus_menu();
    }
}
