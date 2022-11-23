package design_structure_adaptor;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月21日 16:31
 */

public class AdaptorTest {
    public static void main(String[] args) {
        InsideOrderService service = new InsideOrderService();
        boolean result = service.isFirst("12");
        System.out.println("是否是首单" + result);
    }
}
