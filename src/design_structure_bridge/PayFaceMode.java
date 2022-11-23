package design_structure_bridge;

/**
 * @author YanZhao
 * @description 定义刷脸方式接
 * @date 2022年11月21日 20:39
 */

public class PayFaceMode implements IPayMode{


    /**
     * 定义刷脸主要逻辑
     * @param uId
     * @return
     */
    @Override
    public boolean security(String uId) {
        System.out.println("刷脸支付" + uId);
        return false;
    }
}
