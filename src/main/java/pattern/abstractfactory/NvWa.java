package pattern.abstractfactory;

public class NvWa {
    public static void main(String... args){
        //男人生产线
        HumanFactory maleFactory = new MaleFactory();
        //女人生产线
        HumanFactory femaleFactory = new FemaleFactory();

        Human blackHumanMale = maleFactory.createBlackHuman();

        Human blackHumanFemale = femaleFactory.createBlackHuman();
        System.out.println("---生产一个黄人女性");
        blackHumanFemale.getColor();
        blackHumanFemale.talk();
        blackHumanFemale.getSex();
        System.out.println("---生产一个黄人男性");
        blackHumanMale.getColor();
        blackHumanMale.getSex();
        blackHumanMale.talk();
    }
}
