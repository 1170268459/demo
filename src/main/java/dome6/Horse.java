package dome6;

import javafx.beans.binding.StringBinding;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable{

    private static int counter=0;

    private final int id=counter++;

    private int strider=0;

    private static Random rand=new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier b){
        barrier=b;
    }
    public synchronized int getStrider(){
        return strider;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                synchronized (this){
                    strider+=rand.nextInt(3);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (BrokenBarrierException e) {
            System.out.println("BrokenBarrierException");
        }
    }
    public String toString(){
        return "Horse "+id;
    }
    public String tracks(){
        StringBuilder s=new StringBuilder();
        for (int i = 0; i <getStrider(); i++) {
              s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}
