package oukohou.fire_and_shoot.uisee;

import java.math.BigInteger;

/**
 * Created by oukohou on 2017/10/16.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class NumberOfOne {

    public static int findNumberOf1(int A, int B) {
        BigInteger a = new BigInteger(String.valueOf(A));
        BigInteger b = new BigInteger(String.valueOf(B));

        BigInteger result = a.multiply(b);
        String string = result.toString(2);
        char[] chars = string.toCharArray();
        int sum = 0;
        for (char ch :
                chars) {
            if ('1' == ch) {
                sum++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOf1(1, 2));
    }
}
