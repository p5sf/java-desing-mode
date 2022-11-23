package design_structure_decorator;

/**
 * @author YanZhao
 * @description 具体装饰类;给奶茶加入布丁
 * @date 2022年11月21日 21:54
 */

public class Pudding extends DecoratorTea {

    public Pudding(MileTea mileTea) {
        super(mileTea);
    }

    @Override
    public String getName() {
        return super.getName()+"加入布丁";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 10;
    }
}
