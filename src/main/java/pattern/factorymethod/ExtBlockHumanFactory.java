package pattern.factorymethod;

public class ExtBlockHumanFactory extends AbstractHumanFactory{
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        try {
            Human o =(T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("黑人创建错误");
        }
        return null;
    }
}
