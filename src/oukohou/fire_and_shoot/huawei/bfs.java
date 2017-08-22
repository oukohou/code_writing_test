package oukohou.fire_and_shoot.huawei;

import java.util.*;

/**
 * Created by oukohou_ on 2017/8/17.
 * <p>
 * <p> 华为机试题：模块依赖。
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class bfs {

    public LinkedHashMap<String, Boolean> judge_loop(LinkedHashMap<String, Set<String>> map) {
        Queue<String> queue = new LinkedList<>();
        LinkedHashMap<String, Boolean> hash_map_count = new LinkedHashMap<>();

        String pattern = "[a-zA-Z0-9!@#$%^&*()]+";
        for (String very_start : map.keySet()) {
            queue.offer(very_start);
            boolean loop_flag = false;
            HashSet<String> hash_set_mark = new HashSet<>();
            while (!queue.isEmpty()) {
                String start = queue.poll();
                if (!map.containsKey(start)) continue;
                hash_set_mark.add(start);
                for (String end : map.get(start)) {
                    if (end.equals(very_start)) {
                        loop_flag = true;
                        break;
                    }
                    if (hash_set_mark.contains(end)) continue;
                    queue.offer(end);
                    hash_set_mark.add(end);
                }
                if (loop_flag) break;
            }
            hash_set_mark.clear();
            hash_map_count.put(very_start, loop_flag);
        }
        return hash_map_count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Set<String>> map = new LinkedHashMap<>();
        boolean end_flag = false;
        while (scanner.hasNext()) {
            Set<String> set = new LinkedHashSet<>();
            String line = scanner.next();
            if (!line.endsWith(",")) end_flag = true;
            String start = line.split(",")[0];
            start = start.substring(1);
            String end = line.split(",")[1];
            end = end.substring(0, end.length() - 1);
            if (map.containsKey(start)) {
                map.get(start).add(end);
            } else {
                set.add(end);
                map.put(start, set);

            }
            if (end_flag)
                break;
        }
        System.out.println("begin...");
        LinkedHashMap<String, Boolean> hashmap_count = new bfs().judge_loop(map);

        for (Map.Entry<String, Boolean> entry :
                hashmap_count.entrySet()) {
            System.out.println("{" + entry.getKey() + "," + entry.getValue() + "}");

        }
    }
}
