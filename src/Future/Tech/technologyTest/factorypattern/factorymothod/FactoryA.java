package Future.Tech.technologyTest.factorypattern.factorymothod;

/**
 * @ FactoryA.java
 * 具体工厂A
 * 负责打的产品A的生产
 */
public class FactoryA extends Factory{
    @Override
    Product getProduct() {
        return new ProductA();
    }
}
