package design_structure_adaptor;

/**
 * @author YanZhao
 * @description:产品-内部商品
 * @date 2022年11月21日 16:27
 */

public class InsideOrderService implements AdapterOrderService{

    /**
     * 内部商品的具体逻辑
     * @param uId
     * @return
     */
    @Override
    public boolean isFirst(String uId) {
        return false;
    }
}
