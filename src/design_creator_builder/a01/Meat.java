package design_creator_builder.a01;

/**
 * @author YanZhao
 * @description 具体产品的实现类
 * @date 2022年11月21日 11:06
 */

public class Meat implements Food{
    @Override
    public String name() {
        return "五花肉";
    }

    @Override
    public int weight() {
        return 1;
    }

    @Override
    public float price() {
        return 15.5F;
    }
}
