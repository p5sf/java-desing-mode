package design_behavior_visitor;

/**
 * @author YanZhao
 * @description 定义学生访问者
 * @date 2022年11月22日 21:44
 */

public class Student implements User{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

    }
}
