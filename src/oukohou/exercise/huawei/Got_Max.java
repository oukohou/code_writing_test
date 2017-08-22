package oukohou.exercise.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by oukohou on 2017/8/22.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * <p> demo input:
 * 9 10
 * 28 49 11 35 40 17 57 4 6
 * Q 9 9
 * U 9 79
 * Q 9 5
 * Q 4 8
 * U 2 27
 * U 8 40
 * U 4 77
 * U 7 71
 * U 4 44
 * U 8 51
 */
public class Got_Max {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < m; j++) {
            String op = scanner.next();
            int op1 = scanner.nextInt();
            int op2 = scanner.nextInt();
            if (op.equals("Q")) {
                if (op1 > op2) {
                    op2 = op1 ^ op2;
                    op1 = op2 ^ op1;
                    op2 = op2 ^ op1;
                }
                int[] temp = new int[op2 - op1 + 1];
                int count = 0;
                for (int i = op1 - 1; i < op2; i++) {
                    temp[count++] = array[i];
                }
                Arrays.sort(temp);
                System.out.println(temp[temp.length - 1]);
            } else {
                array[op1 - 1] = op2;
            }
        }
    }
}

