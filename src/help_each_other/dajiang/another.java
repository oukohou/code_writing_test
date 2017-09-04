package help_each_other.dajiang;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/4.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class another {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            int[] count = new int[100001];
            int head = 0, tail = 0; //当前区间的头和尾
            int result = 0;

            //输入n个数
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = sc.nextInt();
            }


            for (; tail < arr.length; ++tail) {
                int v = arr[tail];
                ++count[v];
                if (count[v] > k) { //当前这个数出现次数超过了k
                    //计算前一段所有子序列个数
                    result += countSubSeq(tail - head);
                    //头指针移动到这个数第一次出现的下一个位置
                    head = indexOf(arr, head, v) + 1;
                    //减去重复计算了的部分
                    result -= countSubSeq(tail - head);
                }
            }

            System.out.println(result + countSubSeq(tail - head));
        }
    }


    /**
     * 计算一个区间的所有子序列个数
     *
     * @param l 区间长度
     * @return
     */
    private static int countSubSeq(int l) {
        return l * (l + 1) / 2;
    }


    /**
     * 搜索n第一次出现的位置
     *
     * @param arr
     * @param start 搜索起始位置
     * @param n
     * @return
     */
    private static int indexOf(int[] arr, int start, int n) {
        while (arr[start] != n) ++start;
        return start;
    }
}
