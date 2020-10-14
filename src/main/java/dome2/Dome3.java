package dome2;

public class Dome3{
    public class StaticTest extends StaticTEst{

    }
    public class That extends Demo2FinalTest2{

    }

    private StaticTest staticTEst=new StaticTest();
    private That that=new That();

    public void phoneCall(){
        staticTEst.demo2Test();
    }
    public void send(){
        that.ssss();
    }

    public static void main(String[] args) {
        Dome3 dome3=new Dome3();
        dome3.phoneCall();
        dome3.send();
    }
}
