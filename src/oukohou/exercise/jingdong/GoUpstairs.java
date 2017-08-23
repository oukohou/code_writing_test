package oukohou.exercise.jingdong;

import java.math.BigInteger;

/**
 * Created by oukohou on 2017/8/24.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class GoUpstairs {


    public int countWays(int n) {
//        BigInteger result = got_big_int(n);
//        result = result.mod(BigInteger.valueOf(1000000007));
//        return result.intValue();
        if (n <= 0) //防御性编程！！！！！
            return -1;
        int[] ways = new int[n + 1];
        ways[0] = 0;
        ways[1] = 0;
        ways[2] = 1;
        ways[3] = 2;


        if (n > 3) {
            for (int i = 4; i <= n; i++) {
                ways[i] = (ways[i - 1] + ways[i - 2]) % 1000000007;
            }
        }
        return ways[n];
    }

    private BigInteger got_big_int(int n) {
        if (n == 1)
            return BigInteger.ONE;
        if (n == 0)
            return BigInteger.ZERO;
        if (n == 2)
            return BigInteger.ONE.add(BigInteger.ONE);
        BigInteger result_1 = got_big_int(n - 1);
        return result_1.add(got_big_int(n - 2));
    }

    public static void main(String[] args) {
        System.out.println(new GoUpstairs().countWays(3));
    }
}
