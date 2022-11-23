package design_structure_decorator;

/**
 * @author YanZhao
 * @description 抽象类的具体实现-QQ奶茶
 * @date 2022年11月21日 21:47
 */

public class QQMileTea implements MileTea{
    @Override
    public String getName() {
        return "QQ奶茶";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
