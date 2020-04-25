package com.ht.algorithms;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;


public class Solution8_2 {
    private static class Cell implements Comparable<Cell> {
        int row;
        int col;
        int value;
        boolean offLimit;
        boolean isVisited = false;
        public Cell(int r, int c, boolean off, int value) {
            this.row = r;
            this.col = c;
            this.offLimit = off;
            this.value = value;
        }

        public void visit() {
            this.isVisited = true;
        }

        @Override
        public int compareTo(Cell cell) {
            if(cell.row == this.row && cell.col == this.col) return 0;
            return -1;
        }
    }

    /**
     * @param board
     * @return
     */
    public Iterable<Cell> robotInGrid(Cell[][] board) {
        Stack<Cell> path = new Stack<>();
        HashSet<Cell> set = new HashSet<>();
        simulate(board, 0, 0, path, set);
        return path;
    }

    private boolean isValid(Cell[][] board, Cell cell) {
//        System.out.printf("r: %d, c: %d, valid:%b \n", r, c, board.length > r && board[0].length > c && board[r][c] > 0);
        return board.length > cell.row && board[0].length > cell.col && !cell.offLimit;
    }

    private boolean simulate(Cell[][] board, int r, int c, Stack<Cell> path, HashSet<Cell> set) {
        if((board.length <= r || board[0].length <= c) || (!isValid(board, board[r][c]))) return false;
        if(r+1 == board.length && c+1 == board[0].length) return true;

        if(set.contains(board[r][c])) {
            System.out.println("Contains " + r + " " + c);
            return false;
        } else {
            System.out.println("NotContains " + r + " " + c);
            set.add(board[r][c]);
        }

        if(simulate(board, r+1, c, path, set) || simulate(board, r, c+1, path, set)) {
            path.push(board[r][c]);
            return true;
        }
        return false;
    }

    public static void main() {
        Solution8_2 sol = new Solution8_2();
        Cell[][] board = new Cell[4][4];
        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = new Cell(i,j,false, count++);
            }
        }

        board[3][2].offLimit = true;
        for (Cell route:  sol.robotInGrid(board)) {
            System.out.printf("%d \n", route.value);
        }
    }
}
