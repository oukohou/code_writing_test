package huawei;

import java.util.Scanner;

/**
 * Created by oukohou_ on 2017/8/16.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class nick_name {

    public boolean find_3(String a) {
        int count = 0;
        String s = "&=+$,;?/-_.!~*'()#";
        a = a.substring(a.length() - 3);
        for (int i = 0; i < a.length(); i++) {
            if (s.contains(a.substring(i, i + 1)) || a.substring(i, i + 1).matches("[a-zA-Z0-9]")) {
                count += 1;
            }
        }
        return count > 2;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.next();
            for (int i = 0; i < a.length(); i++) {
                int index_at = a.indexOf("@");
                int indexf_dot = a.indexOf(".");
                if (index_at > indexf_dot) {
                    System.out.print(a.substring(0, indexf_dot + 1));
                    a = a.substring(indexf_dot + 1);
                    indexf_dot = a.indexOf(".");
                }
                if (index_at == -1) {
                    System.out.println(a);
                    break;
                } else if (indexf_dot == -1) {
                    System.out.println(a);
                    break;
                }
                if (index_at < 3) {
                    System.out.print(a.substring(0, indexf_dot + 1));
                } else {

                    if (indexf_dot - index_at > 120) {
                        System.out.print(a.substring(0, indexf_dot + 1));
                    } else if (new nick_name().find_3(a.substring(0, index_at))) {
                        System.out.print(a.substring(0, index_at - 3) + "***" + a.substring(index_at, indexf_dot + 1));
                    } else {
                        System.out.print(a.substring(0, indexf_dot + 1));
                    }
                }
                a = a.substring(indexf_dot + 1);
            }

        }
    }
}
