package Designs.TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int r, int c, PlayingPiece piece) {
        if (board[r][c] != null) {
            return false;
        }
        board[r][c] = piece;
        return true;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print("[ ");
            for (int j = 0; j < this.size; j++) {
                String piece = (board[i][j] != null) ? board[i][j].piece.name() : "-";
                System.out.print(piece);
                if (j != this.size - 1) {
                    System.out.print(" , ");
                }
            }
            System.out.print(" ]\n");
        }
    }

    public List<List<Integer>> getFreeCells() {
        List<List<Integer>> cells = new ArrayList<>();

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.board[i][j] == null) {
                    List<Integer> rowCol = new ArrayList<>(2);
                    rowCol.add(i);
                    rowCol.add(j);
                    cells.add(rowCol);
                }
            }
        }

        return cells;
    }

}
