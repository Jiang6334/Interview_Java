package Future.Tech.technologyTest.singleton;

/**
 * @author wj
 * @data 2021/7/2 16:40
 * 单例模式-懒汉式+静态内部类
 * 这种比上面1、2都好一些，既实现了线程安全，又避免了同步带来的性能影响。
 */
public class LazySingleton_3 {
    private static class LazyHolder {
        private static final LazySingleton_3 INSTANCE = new LazySingleton_3();
    }
    private LazySingleton_3 (){}
    public static final LazySingleton_3 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
