package design_creator_factory_simple;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月20日 20:24
 */

public class AwardTest {

    public static void main(String[] args) {
        Award instance = AwardFactory.createInstance(1);
        String name = instance.sendById(2L);
        System.out.println("发送奖品为:" + name);
    }
}
