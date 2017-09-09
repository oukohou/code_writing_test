package oukohou.exercise.sougou;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/8.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class SumOfArrays {

    public double getSum(int n, int m) {
        double sum = 0.0;
        double temp = (double) n;
        for (int i = 0; i < m; i++) {
            sum = sum + temp;
            temp = Math.sqrt(temp);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0, m = 0;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
        }
//        int n = 81;
//        int m = 4;
        double re = new SumOfArrays().getSum(n, m);
        System.out.printf("%.2f", re);
//        System.out.println("%.2f", re);
    }
}
