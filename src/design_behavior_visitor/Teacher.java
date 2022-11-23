package design_behavior_visitor;

/**
 * @author YanZhao
 * @description 定义老师访问者
 * @date 2022年11月22日 21:50
 */

public class Teacher implements User{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
