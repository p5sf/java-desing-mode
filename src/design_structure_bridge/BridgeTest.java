package design_structure_bridge;

import java.math.BigDecimal;

/**
 * @author YanZhao
 * @description 逻辑测试类
 * @date 2022年11月21日 20:43
 */

public class BridgeTest {
    public static void main(String[] args) {
        WxPay pay = new WxPay(new PayFaceMode());
        pay.transfer("1000", new BigDecimal(100));
        System.out.println("微信支付+人脸支付");

    }
}
