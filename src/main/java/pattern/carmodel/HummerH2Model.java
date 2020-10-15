package pattern.carmodel;

public class HummerH2Model extends HummerModel {
    @Override
    public void start() {
        System.out.println("悍马二启动");
    }

    @Override
    public void stop() {
        System.out.println("悍马二停止");
    }

    @Override
    public void alarm() {
        System.out.println("悍马二鸣笛");
    }

    @Override
    public void engineBoom() {
        System.out.println("悍马二引擎发动声音");
    }

}
