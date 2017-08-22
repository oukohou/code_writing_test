package huawei;

import java.util.Scanner;

/**
 * Created by oukohou_ on 2017/8/16.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class same_number_count {

    public int find_match_numbers(String a, String b) {
        if (a.length() != b.length())
            return -1;
        char[] a_char = a.toCharArray();
        char[] b_char = b.toCharArray();
        int length = a.length();
        int count0 = 0;
        int count1 = 0;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            if (!(Character.isDigit(a_char[i]) && Character.isDigit(b_char[i])))
                return -1;
            if (a_char[i] == b_char[i]) {
                count0 += 1;
                if (!flag) {
                    flag = true;
                }
            } else {
                flag = false;
                count1 = Math.max(count0, count1);
                count0 = 0;
            }
            count1 = Math.max(count0, count1);
        }
        return count1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.next();
            String b = scanner.next();
            System.out.println(new same_number_count().find_match_numbers(a, b));
        }
    }
}
