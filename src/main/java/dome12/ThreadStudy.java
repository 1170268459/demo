package dome12;

public class ThreadStudy  implements  Runnable{

    private int size;

    public ThreadStudy(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void run() {

            try {
                System.out.println(size);
                if (size==10){
                    synchronized (this) {
                        wait();
                    }
                }
                System.out.println("执行一次");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


}
