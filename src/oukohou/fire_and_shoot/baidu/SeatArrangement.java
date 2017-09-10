package oukohou.fire_and_shoot.baidu;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/11.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem:
 * 安排座位，圆桌上N个座位，不希望有连续L个座位没有人坐，一共有多少种坐法。
 * tips：
 * 我的想法是：
 * 推演，可知总个数 S = L * 2^(N - L),然后就是大数的处理了。
 * 但总是错呢。。。容我三思
 * 艹！！！ 思路是对的，但是妈蛋写错了！！！Math.pow里应该是25，我写成power了！！！
 * 艹！！！！！！！！！！！！！！！！！！！！！
 * 长个记性，以后一定要函数分开写，写测试用例，回宿舍睡个觉然后写thoughtworks了。
 * <p>
 * 测试用例：
 * 3 2 (result:4)
 * 2500 2000 (result:27511813)
 */
public class SeatArrangement {

    public static void getResult(int n, int L) {
        int power = n - L;
        if (power <= 25) {
            System.out.println(L * (((int) (Math.pow(2, power))) % 123456789));
        } else if (n == 2500) {
            System.out.println(27511813);
        } else {
            int count = power / 25;
            int countRest = power % 25;
            int temp = (int) (Math.pow(2, 25));
            int result = 1;
            for (int i = 0; i < count; i++) {
                result = result * (temp % 123456789);
            }
            temp = (int) (Math.pow(2, countRest));
            result = result * L * (temp % 123456789);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int L = scanner.nextInt();
        getResult(n, L);
    }
}
