package design_creator_factory_abstract;


/**
 * 抽象工厂-发送奖励和抽奖的具体接口,生产具体的对象
 */
public class activityFactoryImpl implements activityFactory{

    @Override
    public Award getAward(String type) {
        if (type =="兑换卡"){
            return new cardGoods();
        }
        if (type == "优惠券") {
            return new couponGoods();
        }
        if (type == "实体物品") {
            return new deliverGoods();
        }
        return null;
    }

    @Override
    public lottery getLottery(int status) {
        if (status == 1) {
            return new TopOne();
        }
        if (status == 2) {
            return new TopTwo();
        }
        return null;
    }
}
