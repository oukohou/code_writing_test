package oukohou.fire_and_shoot.iflytek;

import java.util.*;

/**
 * Created by oukohou on 2017/9/16.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
class Team {
    int score;
    char name;

    public Team(char ch) {
        this.name = ch;
    }
}

public class BallGame {

    public static void sortMap(HashMap<Character, Integer> teams) {

        ArrayList<Map.Entry<Character, Integer>> arrayList = new ArrayList<>(teams.entrySet());

        Collections.sort(arrayList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i = 0; i < teams.size() / 2; i++) {
            System.out.println(arrayList.get(teams.size() / 2 - 1 - i).getKey());
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        int n, totalIterations;
        HashMap<Character, Integer> teams = new HashMap<>();

//        while (scanner.hasNext()) {
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            teams.put(scanner.next().trim().charAt(0), 0);
        }
        totalIterations = n * (n - 1) / 2;

        for (int i = 0; i < totalIterations; i++) {
            string = scanner.next().trim();
            char first = string.charAt(0);
            char second = string.charAt(2);

            string = scanner.next().trim();
            int score1 = (int) string.charAt(0) - 48;
            int score2 = (int) string.charAt(2) - 48;

            if (score1 < score2) {
                teams.put(second, teams.get(second) + 3);
            } else {
                if (score1 > score2) {
                    teams.put(first, teams.get(first) + 3);
                } else {
                    teams.put(second, teams.get(second) + 1);
                    teams.put(first, teams.get(first) + 1);
                }
            }
        }
        sortMap(teams);
        teams.clear();

    }
//    }
}
