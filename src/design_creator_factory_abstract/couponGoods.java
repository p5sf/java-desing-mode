package design_creator_factory_abstract;


/**
 * @author YanZhao
 * @description 具体产品-抽象产品的具体实现 发送奖励-发送优惠券
 *
 * @date 2022年11月20日 20:15
 */

public class couponGoods implements Award {

    @Override
    public String name() {
        return "发送奖励-优惠券";
    }

    @Override
    public int times() {
        return 0;
    }
}
