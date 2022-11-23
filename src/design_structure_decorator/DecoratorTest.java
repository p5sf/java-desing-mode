package design_structure_decorator;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月21日 21:57
 */

public class DecoratorTest {
    public static void main(String[] args) {
        MileTea milkTea = new CocoMileTea();
        // 第一次修饰，为巧克力奶茶添加布丁
        milkTea= new Pudding(milkTea);
        // 第二次修饰，为巧克力奶茶添加珍珠
        milkTea = new Pearl(milkTea);
        System.out.println(milkTea.getName()+"-总价"+milkTea.getPrice());


    }
}
