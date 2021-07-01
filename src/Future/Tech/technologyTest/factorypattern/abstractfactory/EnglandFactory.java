package Future.Tech.technologyTest.factorypattern.abstractfactory;

public class EnglandFactory implements FruitFactory {

    @Override
    public Fruit getApple() {
        return new EnglandApple();
    }

    @Override
    public Fruit getBanana() {
        return new EnglandBanana();
    }
}