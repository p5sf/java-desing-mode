package design_creator_factory_simple;

/**
 * @author YanZhao
 * @description：简单工厂，由子类创建不同的实体类型
 * 被创建的子类都有共同的父类，又被称为静态工厂方法，由根据传入的参数动态决定创建那个子类
 * 只能创建一个产品（发送奖品）
 * @date 2022年11月20日 20:19
 */

public class AwardFactory {

    public static Award createInstance(Integer type) {
        if (1 == type) {
            return new cardGoods();
        }
        if (2 == type) {
            return new deliverGoods();
        }
        if (3 == type) {
            return new cardGoods();
        }
        else {
            throw new RuntimeException("无实体化对象");
        }
    }
}
