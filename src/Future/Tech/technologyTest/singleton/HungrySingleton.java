package Future.Tech.technologyTest.singleton;

/**
 * @author wj
 * @data 2021/7/2 16:56
 * 单例模式-饿汉式
 */
//饿汉式单例类.在类初始化时，已经自行实例化
public class HungrySingleton {
    private HungrySingleton (){}
    private static final HungrySingleton singleton = new HungrySingleton();
    // 静态工厂方法
    public static HungrySingleton getInstance (){
        return singleton;
    }
}
