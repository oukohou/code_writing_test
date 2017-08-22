package oukohou.exercise.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by oukohou on 2017/8/22.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */

class Myobject implements Comparable<Myobject> {

    String name_and_number;
    int count;

    @Override
    public int compareTo(Myobject o) {
        return o.count - this.count;
    }

    public Myobject(String name_and_number, int count) {
        super();
        this.name_and_number = name_and_number;
        this.count = count;
    }

    public String getName_and_number() {
        return name_and_number;
    }

    public void setName_and_number(String name_and_number) {
        this.name_and_number = name_and_number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

public class Record_name {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Myobject> myobjects = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String name_and_number = scanner.nextLine();
            if (name_and_number.trim().equals(""))
                break;
            name_and_number = name_and_number.substring(name_and_number.trim().lastIndexOf("\\") + 1);
            boolean flag = false;
            for (int i = 0; i < myobjects.size(); i++) {
                if (myobjects.get(i).name_and_number.equals(name_and_number)) {
                    myobjects.get(i).setCount(myobjects.get(i).count + 1);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Myobject myobject = new Myobject(name_and_number, 1);
                myobjects.add(myobject);
            }
        }
        scanner.close();
        Collections.sort(myobjects);
        int count = Math.min(8, myobjects.size());
        for (int i = 0; i < count; i++) {
            String name_and_number = myobjects.get(i).getName_and_number();
            String name = name_and_number.split(" ")[0];
            String number = name_and_number.split(" ")[1];
            if (name.length() > 16)
                name = name.substring(name.length() - 16);
            System.out.println(name + " " + number + " " + myobjects.get(i).getCount());
        }
    }
}
