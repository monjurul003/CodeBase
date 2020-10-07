package mik.microsoft;

public class AladdinCheckerGame {
    static int ans = 0;

    public static void main(String[] args) {
        String[] B = new String[]{"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."};
        int N = B.length;
        char[][] board = convert(B, N);
        int ans = solution(board,N);
        System.out.println(ans);
    }

    public static char[][] convert(String[] B, int N) {
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = B[i].charAt(j);
            }
        }
        return board;
    }

    public static int solution(char[][] board, int N) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int[] zafarsPosition = findZafarsPosition(board);

        return dfs(board, zafarsPosition[0],zafarsPosition[1], N);
    }

    public static int dfs(char[][] board, int x, int y, int N) {
        int[][] direction = {{-2, -2}, {-2, 2}}; //zafar can move in the cell
        int result = 0;
        for (int[] dir : direction) {
            int x0 = x + dir[0] / 2;
            int y0 = y + dir[1] / 2;
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            if (x1 >= 0 && x1 < N && y1 >= 0 && y1 < N && board[x1][y1] == '.' && board[x0][y0] == 'X') {
                result = Math.max(result, 1 + dfs(board, x1, y1, N));
            }

        }
        return result;
    }

    private static boolean checkBoundaryAndJumpCondition(char[][] board, int x1, int y1, int x0, int y0, int N) {
        return false;
    }

    public static int[] findZafarsPosition(char[][] board) {
        int[] result = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void solution(char[][] B, int i, int j, int N) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            return;
        }


    }
}
