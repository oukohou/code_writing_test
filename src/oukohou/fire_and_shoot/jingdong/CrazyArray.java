package oukohou.fire_and_shoot.jingdong;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/8.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class CrazyArray {

    public static BigInteger myBigNumSqrt(BigInteger xx) {
        BigDecimal x = new BigDecimal(xx);
        BigDecimal n1 = BigDecimal.ONE;
        BigDecimal ans = BigDecimal.ZERO;
        while ((n1.multiply(n1).subtract(x)).abs().compareTo(BigDecimal.valueOf(0.001)) == 1) {
            BigDecimal s1 = x.divide(n1, 2000, BigDecimal.ROUND_HALF_UP);
            BigDecimal s2 = n1.add(s1);
            n1 = s2.divide(BigDecimal.valueOf(2), 2000, BigDecimal.ROUND_HALF_UP);

        }
        ans = n1;
        BigInteger rt = new BigInteger(ans.toString().split("\\.")[0]);
        return rt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        n = n.multiply(new BigInteger("2"));
        System.out.println(myBigNumSqrt(n));
    }
}
