package dome2;

import io.swagger.models.auth.In;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Demo2Test {
    static String s="ssss";

    private static String function(){

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return "这是一个方法";
    }


    public static void main(String[] args) {
        Demo2FinalTest2 demo2FinalTest2=new Demo2FinalTest2();
        demo2FinalTest2.ssss();
        demo2FinalTest2.test();
        demo2FinalTest2.demo2Test();
        Integer n=15;

        demo2FinalTest2.TestInt(n);
        System.out.println(n);
        List a =new ArrayList();
    }
}
