package design_behavior_template;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月22日 16:32
 */

public class CookTest {
    public static void main(String[] args) {
        CookingTemplate cook = new CookingTemplate();
        cook.cook();
    }
}

abstract class Cooking{
    protected abstract void step1();
    protected abstract void step2();
    protected abstract void step3();

    // 定义制作流程模板
    public void cook(){
        System.out.println("做饭开始:");
        step1();
        step2();
        step3();
        System.out.println("做饭结束");
    }
}

class CookingTemplate extends Cooking{

    @Override
    protected void step1() {
        System.out.println("点火");

    }

    @Override
    protected void step2() {
        System.out.println("放油");

    }

    @Override
    protected void step3() {
        System.out.println("起锅");
    }
}
