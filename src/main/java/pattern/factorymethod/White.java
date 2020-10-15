package pattern.factorymethod;

public class White implements Human {
    @Override
    public void getColor() {
        System.out.println("白人");
    }

    @Override
    public void talk() {
        System.out.println("白人说话是英文");
    }
}
