package oukohou.fire_and_shoot.netease;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by oukohou_ on 2017/8/12.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */

public class Shuffle_cards {

    public int[] shuffle_cards(int[] array, int n, int k) {
        int[] temp = new int[n];
        for (int i = 0; i < k; i++) {
//            System.arraycopy(array, n + 0, temp, 0, n);
            for (int j = 0; j < n; j++) {
                array[2 * n - 2 * j - 1] = temp[n - j - 1];
                array[2 * n - 2 * j - 2] = array[n - j - 1];
            }
        }
        return array;
    }


    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Shuffle_cards.class.getName());
        logger.info("test_logger");
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] array = new int[2 * n];
            for (int j = 0; j < 2 * n; j++) {
                array[j] = scanner.nextInt();
            }
            array = new Shuffle_cards().shuffle_cards(array, n, k);
            for (int j = 0; j < array.length - 1; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println(array[array.length - 1]);
        }

    }
}
