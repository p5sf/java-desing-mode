package design_structure_adaptor;

/**
 * @author YanZhao
 * @description:定义统一适配接口,主要把不同原先不兼容的接口，通过适配器修改做到统一
 * @date 2022年11月21日 16:25
 */

public interface AdapterOrderService {

    /**
     * 判断是否是首单
     * @param uId
     * @return
     */
    boolean isFirst(String uId);
}
