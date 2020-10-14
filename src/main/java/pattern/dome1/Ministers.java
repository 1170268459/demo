package pattern.dome1;

public class Ministers {
    public static void main(String[] args) {
        int  ministersNum=5;
        for (int i = 0; i <ministersNum; i++) {
            Emperors emperors = Emperors.getInstance();
            System.out.println("第"+(i+1)+"个大臣参拜的是");
            emperors.say();
        }
    }
}
