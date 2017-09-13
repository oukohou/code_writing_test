package pleasure.dragon;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/14.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class CoinConvertion {

    public static void getResult(int n) {
        switch (n) {
            case 1:
            case 2:
                System.out.println(1 + "\t" + n);
                break;
            default:
                int category, number;
                if (n < 8) {
                    category = 2;
                    number = category + n - 3;
                } else if (n < 18) {
                    category = 3;
                    number = category + n - 8;
                } else if (n < 38) {
                    category = 4;
                    number = category + n - 18;
                } else if (n < 88) {
                    category = 5;
                    number = category + n - 38;
                } else if (n < 188) {
                    category = 6;
                    number = category + n - 88;
                } else {
                    category = 7;
                    number = category + n - 188;
                }

                System.out.println(category + "\t" + number);
        }
    }


    public static void getResultSmarter(int n) {
    }

//    public static int findIndex(int n) {
//        int[] array = {1, 2, 5, 10, 20, 50, 100};
//
//
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getResult(n);
    }
}
