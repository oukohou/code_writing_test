package oukohou.fire_and_shoot.toutiao;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/8/22.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class max_in_array {

    public int got_max(int[] arrays, int max_scaned, int begin_index, int end_index,
                       boolean changed_former, boolean changed_later) {
        int temp_max = max_scaned * max_scaned;
        int min_index = get_min_index(arrays, begin_index, end_index);
        int sum = get_sum(arrays, begin_index, end_index);
        if (begin_index != end_index)
            temp_max = arrays[min_index] * sum;

        if (begin_index > 0 && changed_former) {
            int former = arrays[begin_index - 1];
            int min = Math.min(arrays[min_index], former);
            int result = (min + sum) * min;
            if (result > temp_max) {
                max_scaned = result;
                got_max(arrays, max_scaned, begin_index - 1, end_index, changed_former, changed_later);
            } else {
                changed_former = false;
            }
        }
        if (end_index < arrays.length - 1 && changed_later) {
            int later = arrays[end_index + 1];
            int min = Math.min(arrays[min_index], later);
            int result = (min + sum) * min;
            if (result > temp_max) {
                max_scaned = result;
                got_max(arrays, max_scaned, begin_index, end_index + 1, changed_former, changed_later);
            } else {
                max_scaned = temp_max;
            }
        }
        return max_scaned;
    }

    private int get_min_index(int[] array, int s, int t) {
        int temp = s;
        for (int i = s + 1; i < t; i++) {
            if (array[i] < array[i + 1])
                temp = i;
        }
        return temp;
    }

    private int get_sum(int[] array, int s, int t) {
        int sum = 0;
        for (int i = s; i <= t; i++) {
            sum += array[i];
        }
        return sum;
    }

//    private int get_temp_max(int[] array, int s, int t){
//        int max = 1;
//        for (int i = s; i <= t; i++) {
//            sum+=array[i];
//        }
//        return sum;
//    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int my_max = 0;
        int temp_index = -1;
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            array[i] = temp;
            if (temp > my_max) {
                temp_index = i;
                my_max = Math.max(temp, my_max);
            }
        }
        int result = new max_in_array().got_max(array, my_max, temp_index, temp_index, true, true);
        System.out.println(result);

    }
}
