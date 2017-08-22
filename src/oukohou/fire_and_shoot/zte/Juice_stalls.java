package oukohou.fire_and_shoot.zte;

/**
 * Created by oukohou on 2017/8/29.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class Juice_stalls {

    int findMinNumberOfJuiceStalls(int numOfStalls, int[] distOfStalls, int[] juiceQuantity, int distance, int initialEnergy) {
        int num_count = 0;
        int dist_count = 0;
        int sum = 0;
        for (int i = 0; i < juiceQuantity.length; i++) {
            sum += juiceQuantity[i];
        }
        if (initialEnergy + sum < distance)
            return -1;

        for (int i = 0; i < juiceQuantity.length; i++) {
            if (initialEnergy < distOfStalls[i] - dist_count) {
                num_count = -1;
                break;
            } else {
                if (initialEnergy > distance - dist_count) {
                    return num_count;
                } else {
                    initialEnergy = initialEnergy - (distOfStalls[i] - dist_count) + juiceQuantity[i];
                    num_count++;
                    dist_count += distOfStalls[i];
                }
            }
        }
        return num_count;
    }

    int find_max(int[] juiceQuan, int begin_index) {
        int temp = -1;
        int index_max = -1;
        for (int i = begin_index; i < juiceQuan.length; i++) {
            if (juiceQuan[i] > temp) {
                temp = juiceQuan[i];
                index_max = i;
            }
        }
        return index_max;
    }


    public static void main(String[] args) {
        int[] dist = {5, 7, 10};
        int[] juice = {2, 3, 5};
        int re = new Juice_stalls().findMinNumberOfJuiceStalls(3, dist, juice, 15, 5);
        System.out.println(re);

    }
}
