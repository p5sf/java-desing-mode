package design_structure_decorator;

/**
 * @author YanZhao
 * @description 具体装饰类，给奶茶加入糖和提高价格
 * @date 2022年11月21日 21:51
 */

public class Sugar extends DecoratorTea{

    public Sugar(MileTea mileTea) {
        super(mileTea);
    }

    @Override
    public String getName() {
        return super.getName()+"加入白糖";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 3;
    }
}
