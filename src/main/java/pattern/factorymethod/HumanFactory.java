package pattern.factorymethod;

public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human=null;
        try {
            human=(T)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("生产人错了，把屁股当成了头");
        }
        return (T)human;
    }
}
