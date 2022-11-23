package design_creator_builder.a01;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月21日 11:20
 */

public class BuilderTest {
    public static void main(String[] args) {
        EatBuilder builder = new EatBuilder();
        Drink coca = builder.getCoca();
        System.out.println(coca.name() + coca.capacity());

    }
}
