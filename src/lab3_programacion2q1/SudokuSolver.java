/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_programacion2q1;


/**
 *
 * @author DELL
 */
public class SudokuSolver extends Sudoku {

    @Override
    public boolean esNumeroValido(int row, int col, int num) {
        for (int c = 0; c < 9; c++) {
            if (sudokuInicial[row][c] == num && c != col) {
                return false;
            }
        }

        for (int r = 0; r < 9; r++) {
            if (sudokuInicial[r][col] == num && r != row) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (sudokuInicial[r][c] == num && (r != row || c != col)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int[][] resolverSudoku() {
        int[][] solucion = new int[9][9];

        // Copia la matriz inicial
        for (int i = 0; i < 9; i++) {
            System.arraycopy(sudokuInicial[i], 0, solucion[i], 0, 9);
        }

        // Llamar al solver recursivo
        if (resolver(solucion)) {
            return solucion;
        }

        return null; // Si no hay solución, retorna null
    }

    private boolean resolver(int[][] tablero) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (tablero[row][col] == 0) { 
                    for (int num = 1; num <= 9; num++) {
                        if (esNumeroValidoEnTablero(tablero, row, col, num)) {
                            tablero[row][col] = num;

                            if (resolver(tablero)) {
                                return true;
                            }

                            tablero[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean esNumeroValidoEnTablero(int[][] tablero, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (tablero[row][i] == num || tablero[i][col] == num) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (tablero[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}