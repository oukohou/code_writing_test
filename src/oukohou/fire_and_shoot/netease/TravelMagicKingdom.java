package oukohou.fire_and_shoot.netease;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/9.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class TravelMagicKingdom {

    public static int dfsWithCertainStep(int[] cities, int step) {

        return -2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int step = scanner.nextInt();
        int[] cities = new int[n];
        cities[0] = 0;
        for (int i = 1; i <= n; i++) {
            cities[i] = scanner.nextInt();
        }

        n = dfsWithCertainStep(cities, step);
        System.out.println(n);

    }
}
