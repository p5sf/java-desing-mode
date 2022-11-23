package design_structure_decorator;

/**
 * @author YanZhao
 * @description具体抽象构件角色-巧克力奶茶
 * @date 2022年11月21日 21:46
 */

public class CocoMileTea implements MileTea {
    @Override
    public String getName() {
        return "巧克力奶茶";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
