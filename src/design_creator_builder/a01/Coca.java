package design_creator_builder.a01;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月21日 11:11
 */

public class Coca implements Drink{
    @Override
    public String name() {
        return "可口可乐";
    }

    @Override
    public int capacity() {
        return 0;
    }
}
