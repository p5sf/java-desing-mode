package desgin_behavior_state;

import jdk.nashorn.internal.ir.IfNode;

/**
 * @author YanZhao
 * @description：缺点添加过多的状态类会变得杂乱
 * 在不同状态下有不同的行为略有不同
 * @date 2022年11月22日 20:26
 */

public class OldTest {
    public static void main(String[] args) {
        String status = "2";
        if (status == "Order") {
            if (status == "1") {
                System.out.println("在订单状态下输出1");
            }
            if (status == "2") {
                System.out.println("在订单状态下输出1");
            }
        }
        if (status == "Gain") {
            if (status == "1") {
                System.out.println("在收货中输出1");
            }
            if (status == "2") {
                System.out.println("在收货中输出2");
            }
        }
    }
}
