package Future.Tech.technologyTest.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 先wait 在notify、notifyAll,等待中的线程才会被唤醒，否则无法唤醒
 * 如果不在同一个代码块，wait notify是不可以用的，不能破坏铁三角关系
 *
 * LockSupport 不受限与前两种的限制，part、unpart不必在意先后顺序
 * LockSupport 正常，不需要new新的锁、无锁块要求
 */
public class LockSupportDemo {
    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        //synchronizedWaitNotify();

        //lockAwaitSingal();

        Thread t5 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "------唤醒");
        }, "t5");
        t5.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t6 = new Thread(() -> {
            LockSupport.unpark(t5);
            System.out.println(Thread.currentThread().getName() + "\t" + "------通知");

        }, "t6");
        t6.start();
    }

    private static void lockAwaitSingal() {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
                try {
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "------唤醒");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t3").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t4").start();
    }

    private static void synchronizedWaitNotify() {
        new Thread(() -> {
            //try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e){e.printStackTrace();}
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "------唤醒");
            }
        }, "t1").start();
        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
            }
        }, "t2").start();
    }

}
