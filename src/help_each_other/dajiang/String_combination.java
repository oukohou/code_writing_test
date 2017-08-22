package help_each_other.dajiang;

import java.util.LinkedList;

/**
 * Created by oukohou on 2017/8/28.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class String_combination {

    public void count_dji_combination(String string) {
        int length = string.length();
        char[] chars = string.toCharArray();
        int[] count_d_forward = new int[length];
        int[] count_i_forward = new int[length];
        LinkedList<Integer> list_j = new LinkedList<>();
        count_d_j_i_forward(chars, count_d_forward, count_i_forward, list_j, string);
        int sum = 0;
        for (Integer j :
                list_j) {
            sum += count_d_forward[j] * (count_i_forward[length - 1] - count_i_forward[j]);
        }
        System.out.println(sum);
    }

    public void count_d_j_i_forward(char[] chars, int[] count_d, int[] count_i, LinkedList<Integer> list_j, String string) {
        count_d[0] = chars[0] == 'd' ? 1 : 0;
        count_i[0] = chars[0] == 'd' ? 1 : 0;
        for (int i = 1; i < chars.length; i++) {
            char temp = chars[i];
            count_i[i] = count_i[i - 1];
            count_d[i] = count_d[i - 1];
            if (temp == 'd') {
                count_d[i] += 1;
            } else if (temp == 'j') {
                list_j.add(i);
            } else if (temp == 'i') {
                count_i[i] += 1;
            }
        }
    }


    public void count_dji_using_jingjingge_method(String string) {
        int count_d = 0;
        int count_dj = 0;
        int sum_dji = 0;
        char[] chars = string.toCharArray();

        for (int i = 0; i < string.length(); i++) {
            if (chars[i] == 'd') {
                count_d += 1;
            } else if (chars[i] == 'j') {
                count_dj = count_dj + count_d;
            } else if (chars[i] == 'i') {
                sum_dji = sum_dji + count_dj;
            }
        }
        System.out.println(sum_dji);
    }


    public static void main(String[] args) {
        String a = "ddjdjii";
        new String_combination().count_dji_combination(a);
        new String_combination().count_dji_using_jingjingge_method(a);
    }
}
