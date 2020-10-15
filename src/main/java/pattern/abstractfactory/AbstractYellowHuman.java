package pattern.abstractfactory;

public abstract class AbstractYellowHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("黄人");
    }

    @Override
    public void talk() {
        System.out.println("黄人说皇帝");
    }

}
