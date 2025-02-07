
package lab3_programacion2q1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGUI extends Sudoku {
    private JTextField[][] cells = new JTextField[9][9];
    JFrame frame = new JFrame();
    private JButton verifyButton;
    private JButton solveButton;
    private SudokuSolver solver;

    public SudokuGUI() {
        solver = new SudokuSolver();

        frame.setTitle("Sudoku GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(9, 9));

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                cells[row][col].setFont(new Font("Arial", Font.BOLD, 20));

                if ((row / 3 + col / 3) % 2 == 0) {
                    cells[row][col].setBackground(new Color(220, 220, 220));
                } else {
                    cells[row][col].setBackground(Color.WHITE);
                }

                if (sudokuInicial[row][col] != 0) {
                    cells[row][col].setText(String.valueOf(sudokuInicial[row][col]));
                    cells[row][col].setEditable(false);
                    cells[row][col].setForeground(Color.BLUE);
                }

                boardPanel.add(cells[row][col]);
            }
        }

        verifyButton = new JButton("Verificar Sudoku");
        verifyButton.addActionListener(e -> verificarSudoku());

        solveButton = new JButton("Mostrar Solución");
        solveButton.addActionListener(e -> mostrarSolucion());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(verifyButton);
        buttonPanel.add(solveButton);

        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void verificarSudoku() {
        boolean isValid = true;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String text = cells[row][col].getText();
                if (!text.isEmpty()) {
                    int num = Integer.parseInt(text);
                    if (!esNumeroValido(row, col, num)) {
                        isValid = false;
                        cells[row][col].setForeground(Color.RED);
                    } else {
                        cells[row][col].setForeground(Color.BLACK);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, isValid ? "¡El Sudoku es válido!" : "Hay errores en el Sudoku.");
    }

    private void mostrarSolucion() {
        int[][] solution = solver.resolverSudoku();
        if (solution != null) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    cells[row][col].setText(String.valueOf(solution[row][col]));
                    cells[row][col].setEditable(false);
                    cells[row][col].setForeground(Color.GREEN);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo resolver el Sudoku.");
        }
    }

    @Override
    public boolean esNumeroValido(int row, int col, int num) {
        return solver.esNumeroValido(row, col, num);
    }

    @Override
    public int[][] resolverSudoku() {
        return solver.resolverSudoku();
    }
}
