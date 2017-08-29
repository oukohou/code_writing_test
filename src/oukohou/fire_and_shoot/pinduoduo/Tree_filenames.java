package oukohou.fire_and_shoot.pinduoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/2.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class Tree_filenames {
    static class Node {
        public Node(String filename) {
            this.filename = filename;
        }

        public Node(String filename, int parent) {
            this.filename = filename;
            this.parent = parent;
        }

        public String filename;
        public int parent;
        public int child_number = 0;
        public ArrayList<Node> children = null;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        String[] strings = new String[n];
        String aline = "";
        String name = "";
        ArrayList<Node> arrayList = new ArrayList<>();
        int parent = -1;
        int[] has_child = new int[n];
        Arrays.fill(has_child, 0);
        for (int i = 0; i < n; i++) {
            aline = scanner.nextLine();
            name = aline.trim().split(" ")[0];
            parent = Integer.valueOf(aline.trim().split(" ")[1]);

            Node temp = new Node(name, parent);
            arrayList.add(temp);
            if (parent != -1) {
                Node temp2 = arrayList.get(parent);
                if (temp2.child_number == 0) {
                    ArrayList<Node> children = new ArrayList<>();
                    children.add(temp);
                    temp2.children = children;
                } else {
                    temp2.children.add(temp);
                }
                temp2.child_number++;
            }
        }
        Node temp;
        String prefix;
        for (int i = 0; i < arrayList.size(); i++) {
            temp = arrayList.get(i);
            while (temp.child_number-- > 0) {
                switch (temp.child_number) {
                    case 0:
                        prefix = "`--";
                        break;
                    case -1:
                }
                prefix = temp.child_number == 0 ? "`--" : "|--";
                System.out.print(prefix);
            }
        }


//        Collections.sort(arrayList, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                if (o1.parent < o2.parent) {
//                    return 1;
//                } else {
//                    if (o1.parent == o2.parent) {
//                        return o1.filename.compareTo(o2.filename);
//                    } else {
//                        return -1;
//                    }
//                }
//            }
//        });
    }
}
