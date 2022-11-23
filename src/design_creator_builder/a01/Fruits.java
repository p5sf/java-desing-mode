package design_creator_builder.a01;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月21日 11:09
 */

public class Fruits implements Food{
    @Override
    public String name() {
        return "水果";
    }

    @Override
    public int weight() {
        return 0;
    }

    @Override
    public float price() {
        return 0;
    }
}
