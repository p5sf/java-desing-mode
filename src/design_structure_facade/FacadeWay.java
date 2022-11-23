package design_structure_facade;


/**
 * @author YanZhao
 * @description：定义统一调度的所有开关,但并不意味只有一个门面可以有FacadeWay2
 * @date 2022年11月22日 22:06
 */

public class FacadeWay {
    // 定义内部所有的访问接口
    private SystemA systemA;

    // 定义统一的的访问方法
    public void visit(){
        SystemA A1 = new SystemA();
        A1.doA();
        SystemB B1 = new SystemB();
        B1.doB();
        SystemC C1 = new SystemC();
        C1.doC();
    }

    public void BC(){
        SystemB B2 = new SystemB();
        B2.doB();
        SystemC C2 = new SystemC();
        C2.doC();
    }

    public void AC(){
        SystemA A1 = new SystemA();
        A1.doA();
        SystemC C2 = new SystemC();
        C2.doC();
    }

}
