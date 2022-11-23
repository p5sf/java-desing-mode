package design_structure_decorator;

/**
 * @author YanZhao
 * @description 抽象装饰器-定义一个抽象构件一致的接口，维护对组件和其子类组件的引用
 * @date 2022年11月21日 21:48
 */

public  abstract class DecoratorTea implements MileTea {

    private MileTea mileTea;

    public DecoratorTea(MileTea mileTea) {
        this.mileTea = mileTea;
    }

    @Override
    public String getName() {
        return mileTea.getName();
    }

    @Override
    public double getPrice() {
        return mileTea.getPrice();
    }
}
