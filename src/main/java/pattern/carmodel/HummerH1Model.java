package pattern.carmodel;

public class HummerH1Model extends  HummerModel{
    @Override
    public void start() {
        System.out.println("发动");
    }

    @Override
    public void stop() {
        System.out.println("停止");
    }

    @Override
    public void alarm() {
        System.out.println("鸣笛");
    }

    @Override
    public void engineBoom() {
        System.out.println("引擎声音发动");
    }


}
