package pattern.abstractfactory;

public interface HumanFactory {
    //制作一个黄种人
    public Human createYellowHuman();
    //制作一个黑人
    public Human createBlackHuman();
    //制作一个白人
    public Human createWhiteHuman();
}
