package design_creator_prototype;

/**
 * @author YanZhao
 * @description 创建用户
 * @date 2022年11月23日 16:39
 */

public class Person implements Cloneable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 克隆对象
    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
