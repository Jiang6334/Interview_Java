package Future.Tech.technologyTest.reenterlockdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁代码实现——同步块
 * 同步方法同理
 */
public class ReenterLockDemo {
    static Object objectLockA = new Object();

    public static void m1(){
        new Thread(()->{
            synchronized (objectLockA){
                System.out.println(Thread.currentThread().getName()+"\t"+"----外层调用");
                synchronized (objectLockA){
                    System.out.println(Thread.currentThread().getName()+"\t"+"----中层调用");
                        synchronized (objectLockA){
                            System.out.println(Thread.currentThread().getName()+"\t"+"----内层调用");

                        }
                }
            }
        },"t1").start();
    }
    synchronized void d1(){
        System.out.println("外");
        d2();
    }
    synchronized void d2(){
        System.out.println("中");
        d3();
    }
    synchronized void d3(){
        System.out.println("内");
    }

    public static void main(String[] args) {
        //同步块
        m1();
        //同步方法
        new ReenterLockDemo().d1();
        Lock lock = new ReentrantLock();
        //加锁几次就要解锁几次，若不匹配当前线程可能会没问题，但是会影响到下面的线程执行，机及其容易导致死锁
        new Thread(()->{
            lock.lock();
            lock.lock();
            try{
                System.out.println("t2外层");
                lock.lock();
                try{
                    System.out.println("t2内层");
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
                //如果这里注释掉下面的解锁，导致上锁解锁次数不匹配，会影响下面的t3线程运行，导致死锁。
                lock.unlock();
            }
        },"t2").start();
        new Thread(()->{
            lock.lock();
            lock.lock();
            try{
                System.out.println("t3外层");
                lock.lock();
                try{
                    System.out.println("t3内层");
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
                lock.unlock();
            }
        },"t3").start();

    }
}
