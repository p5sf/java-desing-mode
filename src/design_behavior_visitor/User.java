package design_behavior_visitor;

/**
 * @author YanZhao
 * @description:建立用户访问者方法，再由不同的用户实现老师和用户
 * @date 2022年11月22日 21:45
 */

public interface User {

    // 定义不同的访问者接口
    public void accept(Visitor visitor);
}
