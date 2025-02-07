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
            if (c != col && sudokuInicial[row][c] == num) {
                return false;
            }
        }

        for (int r = 0; r < 9; r++) {
            if (r != row && sudokuInicial[r][col] == num) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (r != row && c != col && sudokuInicial[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int[][] resolverSudoku() {
        int[][] puzzle = new int[9][9];
        return puzzle;
    }
}

