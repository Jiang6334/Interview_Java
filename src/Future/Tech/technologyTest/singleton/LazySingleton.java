package Future.Tech.technologyTest.singleton;

/**
 * @author wj
 * @data 2021/7/2 16:40
 * 单例模式-经典懒汉式
 */
public class LazySingleton {
    private LazySingleton(){}
    private static LazySingleton lazySingleton = null;
    // 静态工厂方法
    public static LazySingleton getInstance(){
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return  lazySingleton;
    }
}
