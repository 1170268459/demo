package pattern.factorymethod;

public class YellowHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("黄种人");
    }

    @Override
    public void talk() {
        System.out.println("黄种人都高喊为人民服务");
    }

    public void exit(){
        System.out.println("我自己还给自己染了给头发");
    }
}
