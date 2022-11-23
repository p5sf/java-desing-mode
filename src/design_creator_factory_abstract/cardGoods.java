package design_creator_factory_abstract;


/**
 * @author YanZhao
 * @description 具体产品-发送奖励的具体实现-兑换卡
 * @date 2022年11月20日 20:17
 */

public class cardGoods implements Award {


    @Override
    public String name() {
        return "发送兑换卡";
    }

    @Override
    public int times() {
        return 0;
    }
}
