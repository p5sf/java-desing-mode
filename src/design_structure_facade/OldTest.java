package design_structure_facade;

/**
 * @author YanZhao
 * @description:定义统一的外观模式，例如统一的控制白名单
 * @date 2022年11月22日 22:03
 */

public class OldTest {
    public static void main(String[] args) {
        // 访问到门面网关然后访问所有
        String type;
        if ("type" == "网关") {
            // 执行访问A、B、C逻辑
            // A()
            // B()
            // C()
        }
        if ("type" == "AC") {
            //A()
            // C()
        }
    }
}
