package dome2;

import org.omg.PortableInterceptor.ServerRequestInfo;

public class Demo2FinalTest2  extends StaticTEst{

    private int s;
    private String name;

    public void  test(){
        System.out.println("这个没有被final修饰");
    }
    public void TestInt(int test){
        System.out.println(test);
    }

    {
        s=0;
        name="ss";
    }


}
