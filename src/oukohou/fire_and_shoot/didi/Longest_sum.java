package oukohou.fire_and_shoot.didi;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/8/26.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class Longest_sum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (sc.hasNext()) {
            sum += sc.nextInt();
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(sum);
    }
}
