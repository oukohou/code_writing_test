package pleasure.huawei;

import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/13.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class OverlapIP {

    public static int compareTwoStrings(String a, String b) {
        int result;

        int[] intsA = new int[4];
        int[] intsB = new int[4];
        convertStringToInt(a, intsA);
        convertStringToInt(b, intsB);

        result = compareTwoInts(intsA, intsB, 4);

        return result;
    }

    public static void convertStringToInt(String string, int[] ints) {
        String[] strings;
        strings = string.trim().split("\\.");
        for (int i = 0; i < 4; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
    }

    public static int compareTwoInts(int[] intsA, int[] intsB, int length) {
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (intsA[i] < intsB[i]) {
                result = -1;
                break;
            } else {
                if (intsA[i] > intsB[i]) {
                    result = 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String aStart = scanner.next();
        String aEnd = scanner.next();
        String bStart = scanner.next();
        String bEnd = scanner.next();

        int result1 = compareTwoStrings(bEnd, aStart);
        int result2 = compareTwoStrings(aEnd, bStart);
        if (result1 == -1 || result2 == -1) {
            System.out.println("No Overlap IP");
        } else {
            System.out.println("Overlap IP");
        }
    }
}
