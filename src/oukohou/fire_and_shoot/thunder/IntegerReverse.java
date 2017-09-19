package oukohou.fire_and_shoot.thunder;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/19.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * question：
 * 整数翻转。如 -300 变成 -3；-123 变成 -321；
 * tips：
 * 保存正负号，删去末尾0，利用StrignBuilder的内置函数翻转。
 */
public class IntegerReverse {

    public static void reverseString(StringBuilder stringBuilder) {
        if (stringBuilder.length() == 1) { // 其实主要针对0。因为只有一个 0 时，不应删除。
            System.out.println(stringBuilder);
            return;
        }
        boolean negative = false;
        String aString;

        // 删除末尾的0.
        while (stringBuilder.charAt(stringBuilder.length() - 1) == '0') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        // 保存正负号.
        if (stringBuilder.charAt(0) == '-') {
            aString = stringBuilder.substring(1);
            negative = true;
        } else aString = stringBuilder.toString();
        StringBuffer stringBuffer = new StringBuffer(aString);
        stringBuffer.reverse();
        if (negative) {
            System.out.print("-" + stringBuffer);
        } else System.out.print(stringBuffer);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder string = new StringBuilder(scanner.next());
        reverseString(string);


    }
}
