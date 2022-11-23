package design_structure_decorator;

import java.sql.SQLOutput;

/**
 * @author YanZhao
 * @description 装饰器模式：在不改变原有类的基础上新增类，可通过继承、AOP切面实现
 * 装饰器模式可以避免子类过多
 * 例如各种奶茶又可以添加椰奶、红豆各种甜品，至少增加5*5个子类
 * @date 2022年11月21日 21:11
 */

public class OldTest {
    public static void main(String[] args) {

    }
}

 class A{
     public static void main(String[] args) {
         System.out.println("椰奶");
     }

}

class A1 extends A{
    public static void main(String[] args) {
        System.out.println("椰奶加糖");
    }
}
class A2 extends A{
    public static void main(String[] args) {
        System.out.println("椰奶加珍珠");
    }
}

class B{
    public static void main(String[] args) {
        System.out.println("红豆");
    }
}
class B1 extends B{
    public static void main(String[] args) {
        System.out.println("红豆加糖");
    }
}
class B2 extends B{
    public static void main(String[] args) {
        System.out.println("红豆加珍珠");
    }
}
