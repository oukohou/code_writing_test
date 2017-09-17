package oukohou.fire_and_shoot.iflytek;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/16.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem:
 *  争吵：形如的 LLLLRRRRLLRRR 任意字符串，消去规则为满足 RL 则消去任意一个，求消去后的最短长度。
 * tips:
 *  第一个R和最后一个L之间的串全部可以“踢出去”，所以只需找到第一个R和最后一个Ｌ的下标；
 *  若indexR > index L , 查找失败，输出字符串长度length；
 *  否则输出 length - (lastL - firstR)
 */
public class Quarrel {

    public static int getLeftPeople(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        int length = chars.length;
        int sum = length;
        int firstR = 0, lastL = length - 1;
        boolean foundR = false, foundL = false;
        for (int i = 0; i < length; i++) {
            if (chars[i] == 'R' && !foundR) {// 查找第一个R
                foundR = true;
                firstR = i;
            }

            if (chars[length - 1 - i] == 'L' && !foundL) {// 查找第一个L
                foundL = true;
                lastL = length - 1 - i;
            }

            if (foundL && foundR) {
                break;
            }
        }
        if (foundL && foundR && firstR < lastL) { // 找到，并且R在L左边，则更新sum
            sum = length - (lastL - firstR);
        }
        return sum;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        char[] chars = string.toCharArray();
        int sum = getLeftPeople(chars);
        System.out.println(sum);
    }
}
