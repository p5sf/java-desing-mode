package design_creator_factory_abstract;


/**
 * @author YanZhao
 * @description 具体产品-抽象产品发送奖励-发送实体商品
 * @date 2022年11月20日 20:18
 */

public class deliverGoods implements Award {


    @Override
    public String name() {
        return "发送奖励-实体商品";
    }

    @Override
    public int times() {
        return 0;
    }
}
