package dome3;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {

      static class Government implements Generator<String>{
        String[] foundation= ("starange wowen lying in ponds").split(" ");
        private int index;

        @Override
        public String next() {
            return foundation[index++];
        }
    }
    public static void main(String[] args) {
        Set<String> set=new LinkedHashSet<String>(new CollectionData<String>(new Government(),5));
        //set.addAll(CollectionData.list(new Government(),5));
        System.out.println(set);
    }
}
