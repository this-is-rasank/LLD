package Designs.TicTacToe;

public class main {
    public static void main(String[] args) {
        Game game = new Game(3);
        String winner = game.startGame();
        System.out.println("Winner: " + winner);
    }
}
