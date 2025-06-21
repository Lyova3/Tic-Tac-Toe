import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to N x N Tic Tac Toe!");

        while (playAgain) {
            System.out.print("Enter board size (minimum 3): ");
            int size = scanner.nextInt();

            if (size < 3) {
                System.out.println("Board size must be at least 3. Setting size to 3.");
                size = 3;
            }

            scanner.nextLine(); // consume newline

            System.out.print("Enter Player 1 name: ");
            String player1Name = scanner.nextLine();

            System.out.print("Enter Player 2 name: ");
            String player2Name = scanner.nextLine();

            Game game = new Game(size, player1Name, player2Name);
            game.start();

            System.out.print("Would you like to play agin? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("Thankss for playing!");
        scanner.close();
    }
}