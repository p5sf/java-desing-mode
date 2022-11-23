package design_creator_factory_simple;

/**
 * @author YanZhao
 * @description 发送奖品类型-实体商品
 * @date 2022年11月20日 20:18
 */

public class deliverGoods implements Award{
    @Override
    public String sendById(Long id) {
        return "发送实体商品";
    }
}
