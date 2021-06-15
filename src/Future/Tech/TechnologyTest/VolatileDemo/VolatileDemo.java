package Future.Tech.TechnologyTest.VolatileDemo;

import java.util.concurrent.atomic.AtomicInteger;


public class VolatileDemo {
    public static void main(String[] args) {
//        seeOkByVolatile();
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addNumber02();
                    myData.myAtomic();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("zhuxiancheng:"+myData.number);
        System.out.println("zhuxiancheng02:"+myData.atomicInteger);

    }

    private static void seeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"改线程进来了");
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addNumber();
            System.out.println(Thread.currentThread().getName()+"改线程进来了"+myData.number);
        },"AAA").start();

        while (myData.number == 0){

        }
        System.out.println(Thread.currentThread().getName()+"value:"+myData.number);
    }
}
class MyData {

    volatile int number = 0;

    public void addNumber() {
        this.number = 60;
    }
    public void addNumber02() {
        this.number ++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void myAtomic(){
        atomicInteger.getAndIncrement();
    }
}
