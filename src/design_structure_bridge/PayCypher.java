package design_structure_bridge;

/**
 * @author YanZhao
 * @description 定义密码方式的主要逻辑
 * @date 2022年11月21日 20:41
 */

public class PayCypher implements IPayMode{


    @Override
    public boolean security(String uId) {
        System.out.println("密码方式支付" + uId);
        return false;
    }
}
