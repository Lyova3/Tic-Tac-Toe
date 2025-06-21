public class Board {
    private int size;
    private char[][] board;

    public Board(int n) {
        this.size = n;
        this.board = new char[n][n];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != '-') {
            return false;
        }
        board[row][col] = symbol;
        return true;
    }

    public boolean checkWin(char symbol) {
        // Check rows, columns, and diagonals for a win
        return checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol);
    }

    private boolean checkRows(char symbol) {
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean checkColumns(char symbol) {
        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++) {
                if (board[i][j] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private boolean checkDiagonals(char symbol) {
        boolean mainDiagonal = true;
        boolean antiDiagonal = true;

        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) mainDiagonal = false;
            if (board[i][size - 1 - i] != symbol) antiDiagonal = false;
        }

        return mainDiagonal || antiDiagonal;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }
}