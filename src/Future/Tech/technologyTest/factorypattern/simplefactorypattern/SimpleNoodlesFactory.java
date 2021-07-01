package Future.Tech.technologyTest.factorypattern.simplefactorypattern;

public class SimpleNoodlesFactory {
    // 兰州拉面
    public static final int TYPE_LZ = 1;
    //泡面
    public static final int TYPE_PM = 2;
    //河南烩面
    public static final int TYPE_HM = 3;

    public static INoodels createNoodles(int type){
        switch (type){
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_PM:
                return new PaoNoodles();
            case TYPE_HM:
            default:
                return new HuiNoodles();
        }
    }

}
