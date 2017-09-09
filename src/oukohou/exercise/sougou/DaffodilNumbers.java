package oukohou.exercise.sougou;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/8.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem:
 * 输出大于等于n小于等于m的水仙花数。
 * 水仙花数：abc = a*a*a + b*b*b + c*c*c
 * tips:
 * no tips, 暴力输出。
 */
public class DaffodilNumbers {

    public void findDaffodil(int m, int n) {
        boolean flag = false;

        int sum = -1;
        for (int i = m; i <= n; i++) {
            sum = getDaffodilOfSingleNumber(i);
            if (sum == i) {
                flag = true;
                System.out.print(i + " ");
            }
        }
        if (!flag) {
            System.out.println("no");
        }
    }

    private int getDaffodilOfSingleNumber(int i) {
        int sum = 0;
        int temp = i % 10;
        while (i > 0) {
            sum = sum + temp * temp * temp;
            i = i / 10;
            temp = i % 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = 100;
        int n = 120;
//        while (scanner.hasNext()) {
//            m = scanner.nextInt();
//            n = scanner.nextInt();
//        }
        new DaffodilNumbers().findDaffodil(m, n);

    }
}
