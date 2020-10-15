package pattern.abstractfactory;

public abstract class AbstractBlackHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("黑人，哇咔咔");
    }

    @Override
    public void talk() {
        System.out.println("黑人说哇咔咔");
    }

}
