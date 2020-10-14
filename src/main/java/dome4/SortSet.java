package dome4;

import java.util.*;

public class SortSet {
    public static void main(String[] args) {
        SortedSet<String> strings= new TreeSet<>() ;
        Collections.addAll(strings,"ont two three four five".split(" "));
        String first = strings.first();
        String last = strings.last();
        System.out.println(last);

    }

}
