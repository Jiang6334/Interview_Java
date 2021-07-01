package Future.Tech.technologyTest.factorypattern.abstractfactory;

public class Test {

    public static void main(String[] args){
        ChinaFactory chinaFactory = new ChinaFactory();
        Fruit chinaFactoryApple = chinaFactory.getApple();
        chinaFactoryApple.get();
    }
}