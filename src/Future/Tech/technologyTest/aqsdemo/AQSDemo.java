package Future.Tech.technologyTest.aqsdemo;

import Future.Tech.technologyTest.reenterlockdemo.ReenterLockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock  lock = new ReentrantLock();

        new Thread(()->{
            lock.lock();
            try{
                System.out.println("-----A thread come in");
                try{
                    TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }

        },"t1").start();

        new Thread(()->{
            lock.lock();
            try{
                System.out.println("-----B thread come in");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"t2").start();

        new Thread(()->{
            lock.lock();
            try{
                System.out.println("-----C thread come in");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"t3").start();



    }

}
