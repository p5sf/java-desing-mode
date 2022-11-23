package design_structure_bridge;

import java.math.BigDecimal;

/**
 * @author YanZhao
 * @description:定义抽象类的具体实现类扩充 支付宝支付
 * @date 2022年11月21日 20:37
 */

public class ZfbPay extends Pay{

    public ZfbPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, BigDecimal amount) {
        return "支付宝支付";
    }
}
