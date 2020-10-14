package dome9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoNumberSum {

    private static  HashMap<Integer, List<Integer>> add(Integer[] number,Integer sum){
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        HashMap<Integer, List<Integer>> integerObjectHashMap = new HashMap<>();

        for (int i = 0; i < number.length; i++) {
            hashMap.put(number[i],i);
        }
        for (int i = 0; i < number.length; i++) {
            Integer sx= sum-number[i];
            Integer integer = hashMap.get(sx);
            if (integer!=null){
                List<Integer> value=new ArrayList<>();
                value.add(integer);
                integerObjectHashMap.put(sx,value);
            }
        }

        return integerObjectHashMap;
    }

    public static void main(String[] args) {
        Integer[] number={5,12,6,3,9,2,1,7};
        Integer sum=13;
        HashMap<Integer, List<Integer>> add = TwoNumberSum.add(number, sum);

    }
}
