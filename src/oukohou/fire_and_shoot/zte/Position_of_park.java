package oukohou.fire_and_shoot.zte;

/**
 * Created by oukohou on 2017/8/29.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class Position_of_park {
    class Pos {
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x, y;
    }

    public int[] to(int rows, int cols, char[][] positionInPark, int euclidx, int euclidy, int montex, int monteY) {
        int[] result = {0, 0};
        int[] temp = {0, 0};
        boolean flag = false;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; i++) {
                if (!(i == euclidx && j == euclidy) && !(i == montex && j == monteY)) {
                    if (positionInPark[i - 1][j - 1] == '+') {
                        temp[0] = i;
                        temp[1] = j;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                break;
            }
        }
        result[0] = euclidx - temp[0] + montex;
        result[1] = euclidy - temp[1] + monteY;
        System.out.print(temp[0] + "\t" + temp[1]);
        return result;
    }


    public static void main(String[] args) {
        int rows = 4;
        int cols = 8;


    }
}
