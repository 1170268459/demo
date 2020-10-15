package pattern.factorymethod;

public class BlackHuman  implements Human{
    @Override
    public void getColor() {
        System.out.println("黑人");
    }

    @Override
    public void talk() {
        System.out.println("黑人说话听不懂");
    }
}
