package pleasure.tencent;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/13.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class NumberTransfermor {

    public static int getSteps(int a, int b, int A, int B) {
        int step = 0;
        int aDiv = A / a;
        int aMod = A % a;

        int temp;
        boolean found = false;
//        for (int i = 0; i <= aDiv; i++) {
//            for (int j = 0; j <= aMod; j++) {
//                temp = (a + j) * i;
//                if (temp == A && i % 2 == 0) {
//                    step = i / 2 + j;
//                    found = true;
//                    break;
//                }else {
//                    if ()
//                }
//            }
//            if (found) {
//                break;
//            }
//        }

        while (A > a && B > b) {
            while (A % 2 == 0 && B % 2 == 0) {
                A = A / 2;
                B = B / 2;
                step++;
            }
            if (A != a && B != b) {
                A--;
                B--;
                step++;
            }
        }
        return step == 0 ? -1 : step;

    }

    public static boolean verifyInput(int a, int b, int A, int B) {
        int aDiv = a % 2;
        int bDiv = b % 2;
//        if (aDiv != bDiv) {
//            return false;
//        }
        aDiv = A % 2;
        bDiv = B % 2;
        if (aDiv != bDiv) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        boolean verified = verifyInput(a, b, A, B);
        if (!verified) {
            System.out.println(-1);
        } else {
            int step = getSteps(a, b, A, B);
            System.out.println(step);
        }
    }
}
