package pattern.factorymethod;

public class NvWa {
    public static void main(String[] args) {
        //拿出阴阳炉
        AbstractHumanFactory yinYangLu=new HumanFactory();
        //不怕死的白种人来一波
        System.out.println("不怕死的白种人来一波");
        Human human = yinYangLu.createHuman(White.class);
        human.getColor();
        human.talk();
        //会说八嘎的黑种人
        System.out.println("会说八嘎的黑种人搞一波");
        Human blackHuman = yinYangLu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
        //讲着英语的黄种人
        System.out.println("讲着英语的黄种人");
        YellowHuman yellowHuman = yinYangLu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
        yellowHuman.exit();
    }
}
