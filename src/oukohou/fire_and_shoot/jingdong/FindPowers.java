//package oukohou.fire_and_shoot.jingdong;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * Created by oukohou on 2017/9/8.
// * <p>
// * If this runs wrong, don't ask me, I don't know why;
// * If this runs right, thank god, and I don't know why.
// * Maybe the answer, my friend, is blowing in the wind.
// */
//public class FindPowers {
//
//    public static int findThePower(int n, int[] squares) {
//        int sum = 0;
//
//
//    }
//
//    public static int[] getPrime(int n, int sqrtNumber) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 1; i <= sqrtNumber; i++) {
//            if (i == 1 || i == 2 || i == 3) {
//                arrayList.add(i);
//                continue;
//            }
//
//            if (i % 2 == 0 ) continue;
//
//            boolean isPrime = true;
//            for (int j = 3; j <= Math.sqrt(i); j += 2) {
//                if (i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime) {
//                arrayList.add(i);
//            }
//            if (isprime) System.out.print(i + " ");
//            isprime = true;
//        }
//
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int sqrtNumber = (int) Math.sqrt(n);
//        int[] squares = new int[sqrtNumber];
//        int[] cubes = new int[sqrtNumber];
//
//        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
//            squares[i] = i * i;
//        }
//
//        int sum = 0;
//        if (n <= 3) {
//            for (int i = 1; i < n; i++) {
//                sum += n;
//            }
//            sum += n * n;
//        }
//        System.out.println(sum);
//    }
//}
