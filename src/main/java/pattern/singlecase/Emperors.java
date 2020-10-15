package pattern.singlecase;

import java.util.ArrayList;
import java.util.Random;

public class Emperors {
    //定义最多能产生的实例数量
    private static int maxNumOfEmperors=2;
    //每个皇帝都有名字，使用一个ArrayList来容纳。每个对象的私有属性
    private static ArrayList<String> nameList=new ArrayList<String>();
    //定义一个列表，容纳所有的皇帝实例
    private static  ArrayList<Emperors> emperorsArrayList =new ArrayList<Emperors>();
    //当前皇帝的序列号
    private static int countNumOfEmperors=0;

    static {
        for (int i = 0; i < maxNumOfEmperors; i++) {
            emperorsArrayList.add(new Emperors("皇"+(i+1)+"帝"));
        }
    }

    private Emperors(){

    }
    private Emperors(String name){
        nameList.add(name);
    }
    public static Emperors getInstance(){
        Random random=new Random();
        countNumOfEmperors  = random.nextInt(maxNumOfEmperors);
        return emperorsArrayList.get(countNumOfEmperors);
    }
    public static void  say(){
        System.out.println(nameList.get(countNumOfEmperors));
    }
}
