package design_behavior_memento;


/**
 * @author YanZhao
 * @description
 * @date 2022年11月23日 12:27
 */

public class Test {
    public static void main(String[] args) {
        MemorialInfo info = new MemorialInfo();
        // 保存信息
        Person person = new Person("小明", "上海", 12, info);
        // 备份信息
        person.copy();
        person.setName("小王");

        // 恢复数据
        person.restore();
        System.out.println(person);

    }
}

// 备忘录信息
class MemorialInfo {
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// 执行者
class Person {

    private String name;
    private String address;
    private int age;

    // 备忘录信息
    private MemorialInfo memorialInfo;

    public Person(String name, String address, int age, MemorialInfo memorialInfo) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.memorialInfo = memorialInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MemorialInfo getMemorialInfo() {
        return memorialInfo;
    }

    public void setMemorialInfo(MemorialInfo memorialInfo) {
        this.memorialInfo = memorialInfo;
    }


    // 保存备忘录信息
    public void copy() {
        memorialInfo.setName(name);
        memorialInfo.setAge(age);
        memorialInfo.setAddress(address);
    }

    // 数据还原
    public void restore() {
        this.address = memorialInfo.getAddress();
        this.name = memorialInfo.getName();
        this.age = memorialInfo.getAge();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", memorialInfo=" + memorialInfo +
                '}';
    }
}

