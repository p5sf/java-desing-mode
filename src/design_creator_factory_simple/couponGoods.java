package design_creator_factory_simple;

/**
 * @author YanZhao
 * @description 发送奖品类型-优惠券
 *
 * @date 2022年11月20日 20:15
 */

public class couponGoods implements Award {

    @Override
    public String sendById(Long id) {
        return "发送优惠券";
    }

}
