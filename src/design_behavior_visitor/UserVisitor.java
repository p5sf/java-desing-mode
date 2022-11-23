package design_behavior_visitor;

/**
 * @author YanZhao
 * @description:定义具体的实现访问
 * @date 2022年11月22日 21:52
 */

public class UserVisitor implements Visitor{

    @Override
    public void visit(Student student) {
        System.out.println("访问学生的具体逻辑");
    }

    @Override
    public void visit(Teacher teacher) {
        System.out.println("访问老师的具体逻辑");

    }
}
