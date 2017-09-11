package pleasure.dajiang;

import java.math.BigInteger;

/**
 * Created by oukohou on 2017/8/28.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem：
 * 一串数字的二进制表示位有多少位不一样；
 * tips：
 * 直接BIgInteger，函数调用即可。
 */
public class Binary_different_0_1 {

    public void compute(BigInteger[] bigIntegers) {
        int sum = 0;
        for (int i = 0; i < bigIntegers.length; i++) {
            for (int j = i + 1; j < bigIntegers.length; j++) {
                sum += bigIntegers[i].xor(bigIntegers[j]).bitCount();
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BigInteger a = scanner.nextBigInteger();
        BigInteger a = BigInteger.valueOf(2L);
        BigInteger b = BigInteger.valueOf(3L);
        BigInteger re = a.xor(b);
        System.out.println(re.bitCount());
    }
}
