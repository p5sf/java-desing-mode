package design_structure_decorator;

/**
 * @author YanZhao
 * @description 具体装饰角色;向组件添加新的职责 给奶茶加入珍珠
 * @date 2022年11月21日 21:56
 */

public class Pearl extends DecoratorTea{
    public Pearl(MileTea mileTea) {
        super(mileTea);
    }

    @Override
    public String getName() {
        return super.getName()+"加入珍珠";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5;
    }
}
