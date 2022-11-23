package design_structure_bridge;

import java.math.BigDecimal;

/**
 * @author YanZhao
 * 抽象类的扩充-支付方式的具体实现
 * @date 2022年11月21日 20:35
 */

public class WxPay extends Pay{

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    /**
     * 定义微信支付的具体逻辑
     * @param uId
     * @param amount
     * @return
     */
    @Override
    public String transfer(String uId, BigDecimal amount) {
       return "微信支付";
    }
}
