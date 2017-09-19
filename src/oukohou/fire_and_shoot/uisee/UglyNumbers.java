package oukohou.fire_and_shoot.uisee;

/**
 * Created by oukohou on 2017/10/16.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class UglyNumbers {

    public static int getUglyNumber(int N) {
        if (N < 0) {
            return 0;
        }
        if (N == 0) {
            return 1;
        }

        int[] uglyNumbers = new int[N + 1];
        uglyNumbers[0] = 1;
        int count2 = 0;
        int count3 = 0;
        for (int i = 1; i < N + 1; i++) {
            uglyNumbers[i] = getMinNumber(uglyNumbers[count2] * 2, uglyNumbers[count3] * 3);

            while (uglyNumbers[count2] * 2 <= uglyNumbers[i]) count2++;
            while (uglyNumbers[count3] * 3 <= uglyNumbers[i]) count3++;
        }
        return uglyNumbers[N];
    }

    private static int getMinNumber(int count2, int count3) {
        count2 = count2 > count3 ? count3 : count2;
        return count2;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(4));
    }
}
