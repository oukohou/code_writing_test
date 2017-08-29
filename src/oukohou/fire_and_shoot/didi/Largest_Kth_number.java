package oukohou.fire_and_shoot.didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by oukohou on 2017/8/26.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class Largest_Kth_number {
    public static int kthLargestElement(int k, int[] nums) {
        //打乱数组避免最坏情况
//        shuffle(nums);
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && nums[++i] < nums[lo]) ;
            while (j > lo && nums[lo] < nums[--j]) ;
            if (j <= i) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while (scanner.hasNext()) {
            arrayList.add(scanner.nextInt());
        }
        int k = arrayList.get(arrayList.size() - 1);
        int num = arrayList.size();
        int[] a = new int[num - 1];
        for (int i = 0; i < arrayList.size() - 1; i++) {
            a[i] = arrayList.get(i);
//            priorityQueue.add(arrayList.get(i));
//            if (priorityQueue.size()> k)
//                priorityQueue.poll();
        }
//        System.out.println(priorityQueue.peek());
        int res = kthLargestElement(k, a);
        System.out.println(res);
    }
}
