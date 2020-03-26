package com.ht.algorithms;

public class Solution1_8 {
    /**
     * first row and first column can be used instead of rows and cols array: Its a further improvement
     * @param matrix
     */
    public static void zeroMatrix(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if(rows[i]) nullyfyRow(matrix, i);
        }

        for (int i = 0; i < cols.length; i++) {
            if(cols[i]) nullyfyCol(matrix, i);
        }
    }

    private static void nullyfyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullyfyCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[i][col] = 0;
        }
    }
}
