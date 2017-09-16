package oukohou.fire_and_shoot.iflytek;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/16.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
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
            if (chars[i] == 'R' && !foundR) {
                foundR = true;
                firstR = i;
            }

            if (chars[length - 1 - i] == 'L' && !foundL) {
                foundL = true;
                lastL = length - 1 - i;
            }

            if (foundL && foundR) {
                break;
            }
        }
        if (foundL && foundR && firstR < lastL) {
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
