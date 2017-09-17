package oukohou.fire_and_shoot.sensetime;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/17.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */

class Min {
    int begin;
    int end;
    int length;

    public Min(int begin, int end) {
        this.begin = begin;
        this.end = end;
        this.length = end - begin;
    }

    public void refresh(int begin, int end) {
        this.begin = begin;
        this.end = end;
        this.length = end - begin;
    }
}

public class MinInterval {

    public static Min getMin(int[][] numbers, int K, int N) {
        int[] indexes = new int[K];
        int[] mins = new int[K];

        Arrays.fill(indexes, 0);
        for (int i = 0; i < K; i++) {
            mins[i] = numbers[i][0];
        }

        int minIndex = getMinIndex(mins);
        int maxNumberOfMins = getMax(mins);
        int minNumberOfMins = mins[minIndex];

        Min min = new Min(minNumberOfMins, maxNumberOfMins);

        int maxNumberOfIndexes = getMax(indexes);
        while (maxNumberOfIndexes < N - 1) {
            indexes[minIndex]++;

            mins[minIndex] = numbers[minIndex][indexes[minIndex]];
            maxNumberOfMins = maxNumberOfMins > mins[minIndex] ? maxNumberOfMins : mins[minIndex];
            minNumberOfMins = mins[getMinIndex(mins)];


            if (qualify(min, maxNumberOfMins, minNumberOfMins)) {
                min.refresh(minNumberOfMins, maxNumberOfMins);
            }

            maxNumberOfIndexes = maxNumberOfIndexes < indexes[minIndex] ? indexes[minIndex] : maxNumberOfIndexes;
            minIndex = getMinIndex(mins);

        }
        return min;
    }

    public static boolean qualify(Min tempMin, int max, int min) {
        if ((tempMin.length > (max - min)) || ((tempMin.length == max - min) && tempMin.begin > min)) {
            return true;
        }
        return false;
    }


    public static int getMax(int[] indexes) {
        int max = indexes[0];
        for (Integer index :
                indexes) {
            max = max < index ? index : max;
        }
        return max;
    }

    public static int getMinIndex(int[] mins) {
        int minIndex = 0;
        for (int i = 0; i < mins.length; i++) {
            minIndex = mins[i] < mins[minIndex] ? i : minIndex;
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] numbers = new int[K][N];

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                numbers[i][j] = scanner.nextInt();
            }
        }
        Min min = getMin(numbers, K, N);
        System.out.print(min.begin + " " + min.end);

    }
}
