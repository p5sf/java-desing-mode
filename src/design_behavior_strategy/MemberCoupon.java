package design_behavior_strategy;

/**
 * @author YanZhao
 * @description 定义会员优惠逻辑
 * @date 2022年11月22日 16:15
 */

public class MemberCoupon implements CouponStrategy{
    @Override
    public String disCount(int num1) {
        return "会员优惠";
    }

}
