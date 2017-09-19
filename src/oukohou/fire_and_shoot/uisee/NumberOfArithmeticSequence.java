package oukohou.fire_and_shoot.uisee;

/**
 * Created by oukohou on 2017/10/16.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class NumberOfArithmeticSequence {

    public static int findNumberOfArithmeticSequence(int[] A) {
        int sum = 0;
        int addOns = 1;

        for (int i = 2; i < A.length; i++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                sum += addOns;
                addOns++;
            } else {
                addOns = 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {-1, 1, 3, 3, 3, 2, 1, 0};
        System.out.println(findNumberOfArithmeticSequence(A));
        ;

    }
}
