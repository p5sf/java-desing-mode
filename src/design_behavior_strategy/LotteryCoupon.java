package design_behavior_strategy;

/**
 * @author YanZhao
 * @description:定义抽奖优惠策略
 * @date 2022年11月22日 16:16
 */

public class LotteryCoupon implements CouponStrategy{
    @Override
    public String disCount(int num1) {
        return "抽奖优惠";
    }
}
