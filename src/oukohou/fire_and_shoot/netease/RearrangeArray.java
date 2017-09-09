package oukohou.fire_and_shoot.netease;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/9.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class RearrangeArray {

//    public static boolean qualify(int count4, int count2, int n) {
//        boolean flag = false;
//        int count1 = n - count2 - count4;
//        count2 = count2 == 0 ? 0 : 1;
//        if (count4 >= n / 2 || count4 >= count1 - 1 + count2) {
//            flag = true;
//        }
//        return flag;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        int count4 = 0;
        int count2 = 0;
        int count1;
        int temp;
        while (t-- > 0) {
            n = scanner.nextInt();
            count1 = n;
            while (count1-- > 0) {
                temp = scanner.nextInt();
                if (temp % 4 == 0) {
                    count4++;
                    if (count4 >= n / 2) {
                        System.out.println("Yes");
                        count4 = -1;
                        break;
                    }
                } else {
                    if (temp % 2 == 0) {
                        count2++;
                    }
                }
            }

            if (count4 != -1) {
                count1 = n - count2 - count4;
                count2 = count2 == 0 ? 0 : 1;
                if (count4 >= n / 2 || count4 >= count1 - 1 + count2) {
                    System.out.println("Yes");
                } else System.out.println("No");
                count4 = 0;
                count2 = 0;
            }
        }
    }
}
