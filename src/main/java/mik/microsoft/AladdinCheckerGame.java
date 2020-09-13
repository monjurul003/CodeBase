package mik.microsoft;

public class AladdinCheckerGame {
    static int ans = 0;

    public static void main(String[] args) {
        String[] B = new String[]{"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."};
        int N = B.length;
        char[][] b = convert(B, N);
        int[] pos = zafarsPosition(B, N);
        System.out.println("position of zafar is " + pos[0] + ", " + pos[1]);
        int result = 0;
        solution(b,pos[0]-1,pos[0]-1,N);
        result = Math.max(result, ans);
        ans = 0;
        solution(b, pos[0], pos[1], N);
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

    public static int[] zafarsPosition(String[] B, int N) {
        int[] result = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (B[i].charAt(j) == 'O') {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void solution(char[][] B, int i, int j, int N) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            return;
        }


        if (i > 1 && j > 1 && B[i - 1][j - 1] == 'X') {
            B[i - 1][j - 1] = '.';
            ans++;
            solution(B, i - 2, j - 2, N);
        } else if (i > 1 && j < N - 2 && B[i - 1][j + 1] == 'X') {
            B[i - 1][j + 1] = '.';
            ans++;
            solution(B, i - 2, j + 2, N);
        } else if (i < N - 2 && j > 1 && B[i + 1][j - 1] == 'X') {
            B[i + 1][j - 1] = '.';
            ans++;
            solution(B, i + 2, j - 2, N);
        } else if (i < N - 2 && j < N - 2 && B[i + 1][j + 1] == 'X') {
            B[i + 1][j + 1] = '.';
            ans++;
            solution(B, i + 2, j + 2, N);
        }

    }
}
