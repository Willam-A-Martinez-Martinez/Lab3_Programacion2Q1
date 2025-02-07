/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_programacion2q1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *Nadiesda trabajo en esta clase pero tuvo problemas con github
 */
class JuegoFrame extends JFrame {
    public JuegoFrame() {
        setTitle("Juego");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 216, 230));
        
        JLabel lblMensaje = new JLabel("¡Bienvenido al juego!", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblMensaje.setForeground(Color.BLUE);
        add(lblMensaje);
        
        setVisible(true);
    }
}
