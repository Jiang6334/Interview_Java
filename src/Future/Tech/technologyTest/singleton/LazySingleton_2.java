package Future.Tech.technologyTest.singleton;

/**
 * @author wj
 * @data 2021/7/2 16:40
 * 单例模式-懒汉式+双重检查锁定
 */
public class LazySingleton_2 {
    private LazySingleton_2(){}
    private static LazySingleton_2 lazySingleton = null;
    // 静态工厂方法
    public static LazySingleton_2 getInstance(){
        if (lazySingleton == null){
            synchronized (LazySingleton.class){
                if (lazySingleton == null){
                    lazySingleton = new LazySingleton_2();
                }
            }
        }
        return  lazySingleton;
    }
}
