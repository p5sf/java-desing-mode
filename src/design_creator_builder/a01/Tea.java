package design_creator_builder.a01;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月21日 11:17
 */

public class Tea implements Drink{
    @Override
    public String name() {
        return "茶水";
    }

    @Override
    public int capacity() {
        return 0;
    }
}
