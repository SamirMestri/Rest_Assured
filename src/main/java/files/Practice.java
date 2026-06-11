package files;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice {

    static void main(String[]args) {

        List<String> a = new ArrayList<String>();

        a.add("Kiran");

        a.set(0,"Samir");

        Collections.sort(a);

        System.out.println(a.addAll(a));


    }
}
