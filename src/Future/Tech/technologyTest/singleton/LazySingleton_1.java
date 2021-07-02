package Future.Tech.technologyTest.singleton;

/**
 * @author wj
 * @data 2021/7/2 16:40
 * 单例模式-懒汉式+getInstance上加同步代码块
 */
public class LazySingleton_1 {
    private LazySingleton_1(){}
    private static LazySingleton_1 lazySingleton = null;
    // 静态工厂方法
    public static synchronized LazySingleton_1 getInstance(){
        if (lazySingleton == null){
            lazySingleton = new LazySingleton_1();
        }
        return  lazySingleton;
    }
}
