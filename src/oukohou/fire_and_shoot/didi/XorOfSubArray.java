package oukohou.fire_and_shoot.didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/10.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class XorOfSubArray {

    public static int getNumberOfXors(ArrayList<Integer> arrayList, int beginIndex, int engIndex) {
        int n = arrayList.size();
        int sum = 0;
        if (beginIndex < 0 || engIndex > n || beginIndex == engIndex) {
            return 0;
        }


        boolean hasChanged = false;

        int iStep = 1;
        int iSum = 0;

        for (; iStep < n; iStep++) {
            for (int i = 0; i < n - iStep; i++) {
                for (int j = 0; j < iStep; j++) {
                    iSum = iSum + iSum ^ arrayList.get(i + j + 1);
                }
                if (iSum == 0) {
                    sum++;
                    hasChanged = true;
                    sum = sum + getNumberOfXors((ArrayList<Integer>) arrayList.subList(0, i), 0, i);
                    sum = sum + getNumberOfXors((ArrayList<Integer>) arrayList.subList(i + iStep, engIndex), i + iStep, engIndex);
                    break;
                }
            }
            if (hasChanged) break;
        }


        arrayList.clear();
        return sum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = scanner.nextInt();
            if (temp == 0) {
                sum++;
                if (arrayList.size() > 0) {
                    sum += getNumberOfXors(arrayList, 0, arrayList.size());
                }
            } else {
                arrayList.add(temp);
            }
        }
        if (arrayList.size() > 0) {
            sum += getNumberOfXors(arrayList, 0, arrayList.size());
        }

//        int n = 4;
//        int[] array = new int[n];
        System.out.println(sum);
    }
}
