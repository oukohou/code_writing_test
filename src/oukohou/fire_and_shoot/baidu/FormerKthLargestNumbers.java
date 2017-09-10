package oukohou.fire_and_shoot.baidu;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/11.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem：
 * 对糖果的喜爱程度，其实就是最小堆的算法，加了个壳而已，换汤不换药。
 */
public class FormerKthLargestNumbers {


    public static void convert_arrays_to_heap(int[] ints) {
        int index = ints.length / 2 - 1;
        for (int i = index; i >= 0; i--) {
            adjustMinHeap(ints, i);
        }
    }

    private static void adjustMinHeap(int[] ints, int index) {
        int length = ints.length;
        int l_child = index * 2 + 1;
        int temp_index = index;
        if (l_child + 1 < length && ints[temp_index] > ints[l_child + 1]) {
            temp_index = l_child + 1;
        }
        if (l_child < length && ints[temp_index] > ints[l_child]) {
            temp_index = l_child;
        }
        if (temp_index != index) {
            l_child = ints[temp_index];
            ints[temp_index] = ints[index];
            ints[index] = l_child;
            adjustMinHeap(ints, temp_index);
        }
    }

    public static int getSum(int[] ints, int sum) {
        for (Integer integer :
                ints) {
            sum += integer;
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int topK = scanner.nextInt();
        int sum = 0;
        int[] topKs = new int[topK];
        int index = 0;
        for (; index < topK; index++) {
            topKs[index] = scanner.nextInt();
        }
        convert_arrays_to_heap(topKs);
        sum = getSum(topKs, sum);
        System.out.print(sum + "\t");

        int temp;
        for (; index < n - 1; index++) {
            temp = scanner.nextInt();

            if (temp > topKs[0]) {
                sum = sum - topKs[0] + temp;
                topKs[0] = temp;
                adjustMinHeap(topKs, 0);
            }

            System.out.print(sum + "\t");
        }

        temp = scanner.nextInt();

        if (temp > topKs[0]) {
            sum = sum - topKs[0] + temp;
            topKs[0] = temp;
            adjustMinHeap(topKs, 0);
        }

        System.out.print(sum);
    }
}
