package oukohou.fire_and_shoot;

/**
 * Created by oukohou on 2017/9/8.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class DistanceOfCircle {

    public double getBiggestDistance(double[] doubles, int n) {
        double temp = 0;
        double max = Integer.MIN_VALUE;
        double result = 0;
//        quickSort(doubles, 0, n - 1);
        for (int i = 0; i < n; i++) {
//            if (doubles[i] > 180) break;

            temp = doubles[i];
            result = (temp + 180) % 360;
            result = getBiggestDistance(doubles, n, temp, result);
            if (result - max > 0.000000001)
                max = result;
        }
        return max;
    }

    private double getBiggestDistance(double[] doubles, int n, double temp, double result) {

        int low = 0, high = n - 1;
        int middle;
        while (low <= high) {
            middle = (low + high) / 2;
            if (doubles[middle] < result) {
                low = middle + 1;
            } else if (doubles[middle] > result) {
                high = middle - 1;
            } else return 180.00000000;
        }
        if (low >= n) low = n - 1;
        if (high < 0) high = 0;
        double result1 = get360Dis(temp, doubles[low]);
        double result2 = get360Dis(temp, doubles[high]);
        return result1 > result2 ? result1 : result2;

    }


    private double get360Dis(double samll, double big) {
        double re = Math.abs(big - samll);
        if (re > 180) {
            re = 360 - re;
        }
        return re;
    }

    public double[] quickSort(double[] doubles, int i, int j) {
        double temp = doubles[i];
        int s = i;
        int t = j;

        while (i < j) {

            while (i < j && temp <= doubles[j]) j--;
            doubles[i] = doubles[j];

            while (i < j && doubles[i] <= temp) i++;
            doubles[j] = doubles[i];
        }
        doubles[i] = temp;

        if (i > 1 && s < i - 1)
            quickSort(doubles, s, i - 1);
        if (i < doubles.length - 1 && i - 1 < t)
            quickSort(doubles, i + 1, t);
        return doubles;
    }

    public static void main(String[] args) {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            int n = Integer.parseInt(bufferedReader.readLine());
//            double[] doubles = new double[n];
//            for (int i = 0; i < n; i++) {
//                doubles[i] = Double.parseDouble(bufferedReader.readLine());
//                if (doubles[i] > 359) {
//                    doubles[i] = doubles[i] % 359;
//                }
//            }
//        } catch (IOException e) {
//
//        }

        double[] doubles = {0.001, 0.1, 180};
        int n = 3;
        DistanceOfCircle object = new DistanceOfCircle();
        double re = object.getBiggestDistance(doubles, n);
        System.out.printf("%.8f", re, "\n");
    }
}
