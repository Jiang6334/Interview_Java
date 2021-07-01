package Future.Tech.technologyTest.factorypattern.factorymothod;

public class Test {
    public static void main(String[] args) {
        //创建具体的工厂
        FactoryA factoryA = new FactoryA();
        //生产相对应的产品
        factoryA.getProduct().intro();
        FactoryB factoryB = new FactoryB();
        factoryB.getProduct().intro();
    }
}