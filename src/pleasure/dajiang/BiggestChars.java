package pleasure.dajiang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/4.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem:
 * 用数字代替字符串，求当前串在所有字符串中能否数值最大。
 * tips：
 * 几种情况下不是最大：
 *  1.当前字符串是其他字符串的子串；
 *  2.当前字符串的长度比其他字符串的长度小2或者更多，注意小于1的时候可以将另外字符串首字母置为0，可以最大；
 *  3.当前字符串与另外字符串的首字母相同，但长度更小；
 *  4.当前字符串与其他字符串前缀相同，但数值没有别人大：如：当前是aaabc， 其余字符串是aaaab，baaaa； //该点未解决。
 */
public class BiggestChars {

    public static boolean[] has_solution(String[] strings, int n) {
        int[] length_count = new int[n];
        boolean[] flag_count = new boolean[n];
        Arrays.fill(flag_count, true);
        int max_length = -1;

        for (int i = 0; i < n; i++) {
            length_count[i] = strings[i].length();
            max_length = length_count[i] > max_length ? length_count[i] : max_length;
        }

        for (int i = 0; i < n; i++) {
            if (length_count[i] + 1 < max_length) {
                flag_count[i] = false;
                continue;
            }

            for (int j = 0; j < n; j++) {
                String string_i = strings[i];
                String string_j = strings[j];
                if (i != j && !can_be_biggest(string_i, string_j, i, j)) {
                    flag_count[i] = false;
                    break;
                }
            }
        }
        return flag_count;
    }

    private static boolean can_be_biggest(String string_i, String string_j, int i, int j) {
        if (j != i) {
            if (string_j.contains(string_i)) {
                return false;
            }
            if (string_i.substring(0, 1).equals(string_j.substring(0, 1)) && string_i.length() < string_j.length()) {
                return false;
            }
            if (string_i.length() == string_j.length()) {
                String head = string_i.substring(0, 1);
                int k = 0;
                while (string_j.substring(k, k + 1).equals(head)) {
                    if (!string_i.substring(k, k + 1).equals(head))
                        return false;
                    if (k < string_i.length()) {
                        k++;
                    } else {
                        break;
                    }
                }
            }
            return true;
        }
        return true;
    }

    public static void display(boolean[] booleens, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(booleens[i] + "\t");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        boolean[] result = has_solution(strings, n);
        display(result, n);
    }
}
