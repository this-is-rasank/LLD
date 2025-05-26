package Designs.TicTacToe;

import Designs.TicTacToe.Models.*;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Game {
    Board board;
    Queue<Player> players;

    public Game(int board_size) {
        this.players = new LinkedList<>();
        Player xPlayer = new Player("Player1", new PlayingPieceX());
        Player oPlayer = new Player("Player2", new PlayingPieceO());
        this.players.add(xPlayer);
        this.players.add(oPlayer);

        this.board = new Board(3);
    }

    public String startGame() {
        boolean is_over = false;
        Scanner inputScanner = new Scanner(System.in);
        while (!is_over) {
            Player turn = this.players.peek();
            this.board.print();

            List<List<Integer>> freeCells = this.board.getFreeCells();
            if (freeCells.size() == 0) {
                is_over = true;
                continue;
            }

            // System.out.println("Row: ");
            int r = inputScanner.nextInt();
            // System.out.println("Col: ");
            int c = inputScanner.nextInt();

            boolean added = board.addPiece(r, c, turn.getPlayingPiece());
            if (!added) {
                System.out.println("Position is not valid! Try Again.");
                continue;
            }

            players.remove();
            players.add(turn);

            boolean checkWinner = checkWinner(r, c, turn.getPlayingPiece());
            if (checkWinner) {
                inputScanner.close();
                return turn.getName();
            }
        }
        inputScanner.close();
        return "Tie";
    }

    public boolean checkWinner(int row, int col, PlayingPiece piece) {

        // check Row
        for (int j = 0; j < this.board.size; j++) {
            if (this.board.board[row][j] != piece) {
                break;
            } else {
                if (j == this.board.size - 1) {
                    return true;
                }
            }
        }

        // check Cols
        for (int j = 0; j < this.board.size; j++) {
            if (this.board.board[j][col] != piece) {
                break;
            } else {
                if (j == this.board.size - 1) {
                    return true;
                }
            }
        }

        // check Diagonal
        for (int i = 0; i < this.board.size; i++) {
            if (this.board.board[i][i] != piece) {
                break;
            } else {
                if (i == this.board.size - 1) {
                    return true;
                }
            }
        }

        // check opposite Diagonal
        for (int i = 0; i < this.board.size; i++) {
            if (this.board.board[i][this.board.size - i - 1] != piece) {
                break;
            } else {
                if (i == this.board.size - 1) {
                    return true;
                }
            }
        }

        return false;
    }
}