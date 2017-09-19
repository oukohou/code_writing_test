package oukohou.fire_and_shoot.thunder;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/19.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * question:
 * 输入 n 和 m， 求 1到 n 中任意个数的和为 m 的组合的个数。
 * tips：
 * 动态规划：n 在组合里和 n 不在组合里。
 * dp[n][m] = dp[n-1][m] + dp[n-1][m-n];
 * 当然，记得进行合法性判断。
 */
public class IntegerSummation {

    public static int getSum(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {

            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                int diff = j - i;
                if (diff >= 0) dp[i][j] += dp[i - 1][diff];
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int result = getSum(n, m);
        System.out.println(result);
    }
}
