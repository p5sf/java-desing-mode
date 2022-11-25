package design_structure_bridge;

import java.math.BigDecimal;

/**
 * @author YanZhao
 * @description 桥接模式
 * @date 2022年11月21日 20:43
 */

public class BridgeTest {
    public static void main(String[] args) {
        WxPay pay = new WxPay(new PayFaceMode());
        String transfer = pay.transfer("1000", new BigDecimal(100));
        System.out.println("支付方式："+transfer);

    }
}
