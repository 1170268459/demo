package pattern.abstractfactory;

public class FemaleWhiteHuman extends AbstractYellowHuman{
    @Override
    public void getSex() {
        System.out.println("白人女性");
    }
}
