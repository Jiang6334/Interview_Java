package Future.Tech.TechnologyTest.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现：三个线程顺序打印5、10、15，各打印10遍（Condition的使用）
 */
class LockCondition {

    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    private int number = 1;

    public void pirnt5() {
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + '\t' + i);
            }
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void pirnt10() {
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + '\t' + i);
            }
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void pirnt15() {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + '\t' + i);
            }
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class LockDemo {

    public static void main(String[] args) {
        LockCondition lockCondition = new LockCondition();
        new Thread(()->{
            for (int i = 1; i <= 10 ; i++) {
                lockCondition.pirnt5();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 1; i <= 10 ; i++) {
                lockCondition.pirnt10();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 1; i <= 10 ; i++) {
                lockCondition.pirnt15();
            }
        },"CC").start();
    }





}
