package oukohou.fire_and_shoot.uisee;

import java.util.*;

/**
 * Created by oukohou on 2017/10/16.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */

class Photo {
    String string;
    String name;
    String extension;
    int priority;
    String date;

    public Photo(String string, String name, String extension, int priority, String date) {
        this.string = string;
        this.name = name;
        this.extension = extension;
        this.priority = priority;
        this.date = date;
    }

}

public class RenameOfPhotos {

    public static String renamePhotos(String S) {
        LinkedHashMap<String, PriorityQueue<Photo>> cityMap = new LinkedHashMap<>();
        String result = "";
        String[] cityStrings = S.trim().split("\n");

        for (int i = 0; i < cityStrings.length; i++) {
            addToMap(cityStrings[i], cityMap);
        }

        String priority;
        LinkedHashMap<String, String> priorityMap = new LinkedHashMap<>();
        for (int i = 0; i < cityStrings.length; i++) {
            priority = "temp";
            priorityMap.put(cityStrings[i], priority);
        }
        result = getPriority(priorityMap, cityMap);


        return result;
    }

    public static String getPriority(LinkedHashMap<String, String> priorityMap, LinkedHashMap<String, PriorityQueue<Photo>> cityMap) {
        Photo photo;
        PriorityQueue<Photo> priorityQueue;
        int length;
        String priority;
        Set<Map.Entry<String, PriorityQueue<Photo>>> citySet = cityMap.entrySet();
        for (Map.Entry<String, PriorityQueue<Photo>> citySetEntry : citySet) {
            priorityQueue = citySetEntry.getValue();
            length = priorityQueue.size();
            for (int i = 0; i < length; i++) {
                photo = priorityQueue.poll();
                priority = setPriority(i, length);
                priorityMap.put(photo.string, priority);
            }
        }

        StringBuilder result = new StringBuilder();
        Set<Map.Entry<String, String>> prioritySet = priorityMap.entrySet();
        for (Map.Entry<String, String> prioritySetEntry : prioritySet) {
            String string = prioritySetEntry.getKey();
            priority = prioritySetEntry.getValue();

            String[] strings = string.trim().split(",");
            String name = strings[0].split("\\.")[0];
            String extension = strings[0].split("\\.")[1];
            String city = strings[1].trim();

            result.append(city + priority + "." + extension + "\n");
        }


        return String.valueOf(result);
    }

    private static String setPriority(int i, int length) {
        int priority = i + 1;
        int count = String.valueOf(priority).length();
        count = String.valueOf(length).length() - count;

        String result = "";
        for (int j = 0; j < count; j++) {
            result = result + "0";
        }
        result = result + priority;
        return result;

    }

    public static void addToMap(String string, LinkedHashMap<String, PriorityQueue<Photo>> cityMap) {
        String[] strings = string.trim().split(",");
        String name = strings[0].split("\\.")[0];
        String extension = strings[0].split("\\.")[1];
        String city = strings[1];
        String date = strings[2];
        int priority = 0;
        Photo photo = new Photo(string, name, extension, priority, date);

        if (!cityMap.containsKey(city)) {
            PriorityQueue<Photo> priorityQueue = new PriorityQueue<>(new Comparator<Photo>() {
                @Override
                public int compare(Photo o1, Photo o2) {
                    return o1.date.compareTo(o2.date);
                }
            });
            priorityQueue.add(photo);
            cityMap.put(city, priorityQueue);
        } else {
            cityMap.get(city).add(photo);
        }
    }

    public static void main(String[] args) {
        String a = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";
        System.out.println(renamePhotos(a));
    }
}
