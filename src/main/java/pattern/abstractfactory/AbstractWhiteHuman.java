package pattern.abstractfactory;

public abstract class AbstractWhiteHuman implements  Human {
    @Override
    public void getColor() {
        System.out.println("白人，Fei");
    }

    @Override
    public void talk() {
        System.out.println("白人说Fei");
    }
}
