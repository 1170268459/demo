package pattern.carmodel;

public abstract class HummerModel {
    //启动
    public abstract void start();
    //停止
    public abstract void stop();
    //喇叭
    public abstract void alarm();
    //引擎发动声音
    public abstract void engineBoom();
    //go go go
    public final void run(){
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    };
}
