package Future.Tech.technologyTest.factorypattern.factorymothod;

/**
 * @ FactoryB.java
 * 具体工厂B
 * 负责打的产品A的生产
 */
public class FactoryB extends Factory {
    @Override
    Product getProduct() {
        return new ProductB();
    }
}
