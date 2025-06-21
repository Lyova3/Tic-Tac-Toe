import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public Game(int size, String player1Name, String player2Name) {
        this.board = new Board(size);
        this.player1 = new Player(player1Name, 'X');
        this.player2 = new Player(player2Name, 'O');
        this.currentPlayer = player1;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Starting Tic Tac Toe Game (" + board.getSize() + "x" + board.getSize() + ")");

        while (true) {
            board.display();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");

            int row = getInput("Enter row (1-" + board.getSize() + "): ") - 1;
            int col = getInput("Enter column (1-" + board.getSize() + "): ") - 1;

            if (!board.makeMove(row, col, currentPlayer.getSymbol())) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.display();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isFull()) {
                board.display();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
    }

    private int getInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number!");
            System.out.print(prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}