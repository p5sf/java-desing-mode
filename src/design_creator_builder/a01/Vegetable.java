package design_creator_builder.a01;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月21日 11:10
 */

public class Vegetable implements Food{
    @Override
    public String name() {
        return "蔬菜";
    }

    @Override
    public int weight() {
        return 3;
    }

    @Override
    public float price() {
        return 5.20F;
    }
}
