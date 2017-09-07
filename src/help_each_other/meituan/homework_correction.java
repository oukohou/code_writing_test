package help_each_other.meituan;

/**
 * Created by oukohou on 2017/8/31.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem：
 * 分组循环批改作业，不能重复批改到自己的；
 * tips：
 * 排序之后，只需要最大值小于其余值的和。
 */
public class homework_correction {
    public void yes_or_no(int[] groups) {
        quickSort(groups, 0, groups.length - 1);
        int sum = sum_of_head(groups);
        if (groups[groups.length - 1] > sum) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    private int sum_of_head(int[] groups) {
        int sum = 0;
        for (int i = 0; i < groups.length - 1; i++) {
            sum += groups[i];
        }
        return sum;
    }

    private void quickSort(int[] groups, int i, int j) {
        int temp = groups[i];//暂存值。
        int s = i;//存取起始位。
        int t = j;//存取结束位。
        while (i < j) {//一次循环的条件。
            while (i < j && temp < groups[j]) j--;//先比较标志位右侧的数字
            if (i < j) {// 说明是不满足第二个条件而退出循环。
                groups[i] = groups[j];
                i++;
            }

            while (i < j && groups[i] < temp) i++;//再比较标志位左侧的数字
            if (i < j) {//说明是不满足第二个条件而退出循环。
                groups[j] = groups[i];
                j--;
            }
        }
        groups[i] = temp;//完成标志位的最终位置置位。

        if (s < t) {//递归条件。
            if (i > 1)//手动防越界溢出。
                quickSort(groups, s, i - 1);
            if (i < groups.length - 1)//手动防越界溢出。
                quickSort(groups, i + 1, t);
        }
    }


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] groups = new int[n];
//        for (int i = 0; i < n; i++) {
//            groups[i] = scanner.nextInt();
//        }
        int n = 2;
        int[] groups = {2, 7};
        if (n == 0 || n == 1) {
            System.out.println("No");
        }
        new homework_correction().yes_or_no(groups);


    }
}
