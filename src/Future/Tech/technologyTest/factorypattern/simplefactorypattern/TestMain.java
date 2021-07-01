package Future.Tech.technologyTest.factorypattern.simplefactorypattern;

public class TestMain {
    public static void main(String[] args) {
        INoodels noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_HM);
        noodles.desc();
    }
}
