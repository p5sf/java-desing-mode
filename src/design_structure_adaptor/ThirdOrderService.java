package design_structure_adaptor;

/**
 * @author YanZhao
 * @description 产品-第三方商品判断是否是首单
 * @date 2022年11月21日 16:29
 */

public class ThirdOrderService implements AdapterOrderService{


    /**
     * 逻辑判断-判断第三方商品是否是首单
     * @param uId
     * @return
     */
    @Override
    public boolean isFirst(String uId) {
        return true;
    }
}
