package oukohou.fire_and_shoot.didi;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/10.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class UglyNumber {

    public static int getUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int count2 = 0;
        int count3 = 0;
        int count5 = 0;
        for (int i = 1; i < n; i++) {
            uglyNumbers[i] = getMinNumber(uglyNumbers[count2] * 2, uglyNumbers[count3] * 3, uglyNumbers[count5] * 5);

            while (uglyNumbers[count2] * 2 <= uglyNumbers[i]) count2++;
            while (uglyNumbers[count3] * 3 <= uglyNumbers[i]) count3++;
            while (uglyNumbers[count5] * 5 <= uglyNumbers[i]) count5++;
        }
        return uglyNumbers[n - 1];

    }

    private static int getMinNumber(int count2, int count3, int count5) {
        count2 = count2 > count3 ? count3 : count2;
        count2 = count2 > count5 ? count5 : count2;
        return count2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getUglyNumber(n));
    }
}
