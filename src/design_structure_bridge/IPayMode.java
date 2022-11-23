package design_structure_bridge;


/**
 * 实现类接口
 * 定义支付方式模式接口，桥接接口
 */
public interface IPayMode {

    boolean security(String uId);
}
