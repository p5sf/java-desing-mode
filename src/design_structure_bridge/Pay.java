package design_structure_bridge;

import java.math.BigDecimal;

/**
 * @author YanZhao
 * @description 抽象类：定义了支付方式和转账接口
 * @date 2022年11月21日 20:30
 */

public abstract class Pay {

    /**
     * 定义桥接接口IPayMode,并在构造函数中定义支付方式
     */
    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    /**
     * 定义共同实现转账接口
     * @param uId
     * @param amount
     * @return
     */
    public abstract String transfer(String uId, BigDecimal amount);
}
