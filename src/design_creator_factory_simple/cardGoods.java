package design_creator_factory_simple;

/**
 * @author YanZhao
 * @description 发送奖品类型-兑换卡
 * @date 2022年11月20日 20:17
 */

public class cardGoods implements Award{
    @Override
    public String sendById(Long id) {
        return "发送兑换卡";
    }
}
