package design_behavior_strategy;

/**
 * @author YanZhao
 * @description 现金优惠券
 * @date 2022年11月22日 16:17
 */

public class CashCoupon implements CouponStrategy{
    @Override
    public String disCount(int num1) {
        return "现金优惠";
    }

}
