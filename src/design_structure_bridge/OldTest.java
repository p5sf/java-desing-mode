package design_structure_bridge;

import javax.sound.midi.Soundbank;

/**
 * @author YanZhao
 * @description:主要实现不同的实现进行组合 比如支付（微信、支付宝、银行卡）验证方式（刷脸、密码）进行组合验证
 * @date 2022年11月21日 16:41
 */

public class OldTest {
    public static void main(String[] args) {
        String status = "1";
        if (status == "1") {
            if (status == "11") {
                System.out.println("微信+刷脸");
            }
            if (status == "12") {
                System.out.println("微信+密码");
            }
        }
        if (status == "2") {
            if (status == "21") {
                System.out.println("支付宝+刷脸");
            }
            if (status == "22") {
                System.out.println("支付宝+密码");
            }
        }
    }
}
