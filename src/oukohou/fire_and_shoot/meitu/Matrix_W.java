package oukohou.fire_and_shoot.meitu;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/4.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class Matrix_W {

    public static int[][] get_W(int[][] F, int n, int r) {
        int[][] W = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                W[i][j] = 0;
            }
        }
        int index_X = -1;
        int index_Y = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                index_X = Math.max(i - r, 0);
                while (Math.abs(index_X - i) <= r && index_X < n) {
                    index_Y = Math.max(j - r, 0);
                    while (Math.abs(index_Y - j) <= r && index_Y < n) {
                        W[i][j] += F[index_X][index_Y];
                        index_Y++;
                    }
                    index_X++;
                }
            }
        }
        return W;
    }

    public static void display(int[][] W, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(W[i][j] + "\t");
            }
            System.out.println(W[i][n - 1]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[][] F = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                F[i][j] = scanner.nextInt();
            }
        }

        int[][] W = new int[n][n];
        W = get_W(F, n, r);
        display(W, n);

    }
}
