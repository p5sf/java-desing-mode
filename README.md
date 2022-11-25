

<img src="https://java-note-pic.oss-cn-beijing.aliyuncs.com/java/1.9 设计模式秘籍图谱.jpg" alt="设计模式图谱">

## 目录

创建者模式

[单例模式](https://github.com/sundayskys/java-desing-mode#单例模式)

[简单工厂模式](https://github.com/sundayskys/java-desing-mode#简单工厂模式)

[抽象工厂模式](https://github.com/sundayskys/java-desing-mode#抽象工厂模式)

[原型设计模式](https://github.com/sundayskys/java-desing-mode#原型设计模式)

结构性模式

[适配器模式](https://github.com/sundayskys/java-desing-mode#适配器模式)

[桥接模式](https://github.com/sundayskys/java-desing-mode#桥接模式)

[组合模式](https://github.com/sundayskys/java-desing-mode#组合模式)

[装饰器模式](https://github.com/sundayskys/java-desing-mode#装饰器模式)

[外观模式](https://github.com/sundayskys/java-desing-mode#外观模式)

[享元模式](https://github.com/sundayskys/java-desing-mode#享元模式)

[代理模式](https://github.com/sundayskys/java-desing-mode#代理模式)

行为模式

[责任链模式](https://github.com/sundayskys/java-desing-mode#责任链模式)

[命令模式](https://github.com/sundayskys/java-desing-mode#命令模式)

[迭代器模式](https://github.com/sundayskys/java-desing-mode#迭代器模式)

[中介者模式](https://github.com/sundayskys/java-desing-mode#中介者模式)

[备忘录模式](https://github.com/sundayskys/java-desing-mode#备忘录模式)

[观察者模式](https://github.com/sundayskys/java-desing-mode#观察者模式)

[状态模式](https://github.com/sundayskys/java-desing-mode#状态模式)

[策略模式](https://github.com/sundayskys/java-desing-mode#策略模式)

[模板模式](https://github.com/sundayskys/java-desing-mode#模板模式)

[访问者模式](https://github.com/sundayskys/java-desing-mode#访问者模式)

## 创建者模式

目的：都是为了接口无法创建对象

#### 单例模式

**保证一个类仅有一个实例**，并提供一个访问他的全局访问点，它只会创建一个对象，不允许外部直接创建实例，所以默认在构造函数添加私有属性。

懒汉式：只有在调用才会实例化，线程不安全

```java
public class Singleton_01 {
    private static Singleton_01 instance;

	// 私有构造
    private Singleton_01(){}

    public static Singleton_01 getInstance() {
        if (instance != null) {
            return instance;
        }
        return new Singleton_01();
    }
}
```

懒汉模式：方法加锁，线程安全 耗资源

```java
public class Singleton_02 {
    private static Singleton_02 instance;

    private Singleton_02(){}

    public static synchronized Singleton_02 getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new Singleton_02();
        return instance;
    }
}
```

饿汉模式：在程序启动时加载，后续有外部直接加载获取即可，线程安全

```java
public class Singleton_03 {
    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03(){}

    public static Singleton_03 getInstance() {
        return instance;
    }
}
```

类的内部类：使用类的静态内部类，既保证安全，又保证懒加载，同时又因为是静态只会加载一次，不耗费性能。

```java
public class Singleton_04 {
    
    private static class SingletonHolder{
        private static Singleton_04 instance = new Singleton_04();
    }
    private Singleton_04(){}

    public static Singleton_04 getInstance() {
        return SingletonHolder.instance;
    }
}
```

双重锁校验：线程安全

```java
public class Singleton_05 {
    private volatile static Singleton_05 instance;

    private Singleton_05(){}

    public static Singleton_05 getInstance() {
        // 判断单例对象是否创建，对象已经创建不必进入同步代码块,直接返回
        if (instance != null) {
            return instance;
        }
        // 获取锁
        synchronized (Singleton_05.class) {
            if (instance == null) {
                instance = new Singleton_05();
            }
            return instance;
        }
    }
}
```

#### 简单工厂模式

⼯⼚模式⼜称⼯⼚⽅法模式，在⽗类中提供⼀个创建对象的⽅法， 由⼦类决定实例化那个工厂类，然后在不同的子类对象实现共同的目标。被创建的子类都有共同的父类。

案例：模拟互联网在营销场景业务，统一兑换（兑换接口）之下又有兑换卡、优惠券、实物卡等子类

 缺点：造成过多的产品子类型，因此常和其他模式搭配

定义兑换接口，模拟兑换奖励接口

```java
public interface Award {

    public abstract String sendById(Long id);
}
```

模拟实现子类，有三种方式去兑换奖励接口，逻辑具体实现如下

```java
public class cardGoods implements Award{
    @Override
    public String sendById(Long id) {
        return "发送兑换卡";
    }
}

public class couponGoods implements Award {

    @Override
    public String sendById(Long id) {
        return "发送优惠券";
    }
}

public class matterGoods implements Award{
    @Override
    public String sendById(Long id) {
        return "发送实体商品";
    }
}

```

模拟工厂类，作用实例化子类，根据传入的参数决定实例化那个子类

```java
public class AwardFactory {

    public static Award createInstance(Integer type) {
        if (1 == type) {
            return new cardGoods();
        }
        if (2 == type) {
            return new deliverGoods();
        }
        if (3 == type) {
            return new cardGoods();
        }
        else {
            throw new RuntimeException("无实体化对象");
        }
    }
}
```

模拟测试

```java
public class AwardTest {

    public static void main(String[] args) {
        Award instance = AwardFactory.createInstance(1);
        String name = instance.sendById(2L);
        System.out.println("发送奖品为:" + name);
    }
}
```

#### 抽象工厂模式

抽象工厂是一个中心工厂，创建其他工厂的模式，不同的方法但实际上执行的方法是一样的（做一样的事，但有不同的操作）解决了不同类型的产品下的接口选择功能。所要解决的问题是一个产品组，存在不同的类型产品。

场景：创建的是一个产品族时

缺点：产品族过多

定义奖励系统抽象接口，有兑换方法、和抽奖方法是两个不同的系列产品

```java
public interface activityFactory {

    /**
     * 定义两个产品 -发送奖励和抽奖
     * @return
     */
    public abstract Award getAward(String type);

    public abstract lottery getLottery(int status);
}
```

生产具体对象

```java
public class activityFactoryImpl implements activityFactory{

    @Override
    public Award getAward(String type) {
        if (type =="兑换卡"){
            return new cardGoods();
        }
        if (type == "优惠券") {
            return new couponGoods();
        }
        if (type == "实体物品") {
            return new deliverGoods();
        }
        return null;
    }

    @Override
    public lottery getLottery(int status) {
        if (status == 1) {
            return new TopOne();
        }
        if (status == 2) {
            return new TopTwo();
        }
        return null;
    }
}
```

发送产品之一（发送奖品）

```java
public interface Award {

    /**
     * 获取奖品名称
     * @return
     */
    String name();

    /**
     * 获取奖品个数
     * @return
     */
    int times();

}
```

发送奖品的具体实现子类

```java
public class cardGoods implements Award {

    @Override
    public String name() {
        return "发送兑换卡";
    }

    @Override
    public int times() {
        return 0;
    }
}
public class couponGoods implements Award {

    @Override
    public String name() {
        return "发送奖励-优惠券";
    }

    @Override
    public int times() {
        return 0;
    }
}
public class deliverGoods implements Award {


    @Override
    public String name() {
        return "发送奖励-实体商品";
    }

    @Override
    public int times() {
        return 0;
    }
}
```

抽奖产品之一（抽奖）

```java
public interface lottery {
	// 抽奖奖励
    String levelAward(Integer times);
	// 抽奖次数
    int times();
}
```

具体实现子类

```java
public class TopOne implements lottery{
    @Override
    public String levelAward(Integer times) {
        return "抽了" + times + "次" + "抽到一等奖";
    }

    @Override
    public int times() {
        return 2;
    }
}
public class TopTwo implements lottery{
    @Override
    public String levelAward(Integer times) {
        return "抽了" + times + "次" + "抽到二等奖";
    }

    @Override
    public int times() {
        return 1;
    }
}
```

测试

```java
public class abstractFactoryTest {
    public static void main(String[] args) {
        activityFactoryImpl factory = new activityFactoryImpl();
        Award award = factory.getAward("兑换卡");
        String name = award.name();
        int times = award.times();
        System.out.println("获取发送奖品的名称" + name + "获取多少张：" + times);

        lottery lottery = factory.getLottery(1);
        String level = lottery.levelAward(1);
        System.out.println("获取一等奖" + level);
    }
}
```



#### 建造者模式

通过多个简单对象通过一步步封装构建出一个复杂对象的过程。用户不知道的具体构建细节。注意：基本材料不能变，材料之间相互组合

场景：不同的套餐组合（基本材料不变，这些组合方式组合）

缺点：创建者所创建的产品具有较多的共同点，例如套餐有吃喝相互关联。相互关联不大，不建议使用。

创建建造者：创建实例化子类对象并组装子类对象

```java
public class EatBuilder {

    public Drink getCoca(){
        return new Coca();
    }
    public Drink getTea(){
        return new Tea();
    }
    public Food getMeat(){
        return new Meat();
    }

    public Food getFruits(){
        return new Fruits();
    }

    public Food getVegetable(){
        return new Vegetable();
    }
}
```

材料的实现类，有食品、饮料接口

```java
public interface Food {

    public String name();

    public int weight();

    public float price();
}

public interface Drink {

    public String name();

    public int capacity();
}
```

子类的实现

```java
public class Coca implements Drink{
    @Override
    public String name() {
        return "可口可乐";
    }

    @Override
    public int capacity() {
        return 0;
    }
}

public class Tea implements Drink{
    @Override
    public String name() {
        return "茶水";
    }

    @Override
    public int capacity() {
        return 0;
    }
}
```

食品的具体实现

```java
public class Fruits implements Food{
    @Override
    public String name() {
        return "水果";
    }

    @Override
    public int weight() {
        return 0;
    }

    @Override
    public float price() {
        return 0;
    }
}

public class Meat implements Food{
    @Override
    public String name() {
        return "五花肉";
    }

    @Override
    public int weight() {
        return 1;
    }

    @Override
    public float price() {
        return 15.5F;
    }
}

public class Vegetable implements Food{
    @Override
    public String name() {
        return "蔬菜";
    }

    @Override
    public int weight() {
        return 3;
    }

    @Override
    public float price() {
        return 5.20F;
    }
}
```

#### 原型设计模式

解决创建重复对象，减少资源的浪费，主要实现`Cloneable`，类似与`New`，克隆出来的对象属性值相同。并且克隆出来的新对象不会影响原型对象，然后再修改克隆对象。

原型模式很少单独出现一般和工厂模式一起出现。通过`clone`创建一个对象，然后由工厂方法提供给调用者。

**推荐**：如果系统要保存对象状态且对象状态变化很小，可使用原型模式配合备忘录模式使用，如果对象的状态变化很大，则采用状态模式比原型模式好很多。

**场景**：细胞分裂

创建克隆对象：浅克隆

```java
public class ShallowClone implements Cloneable {

    private String name;
    private int age;
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

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

    @Override
    protected ShallowClone clone() throws CloneNotSupportedException {
        return (ShallowClone) super.clone();
    }
}
```

创建深克隆

```java
    @Override
    protected  DeepClone clone() throws CloneNotSupportedException {
        DeepClone clone1 = (DeepClone) super.clone();
        List<String> list1=new ArrayList<>();
        for (String list2 : list){
            list1.add(list2);
        }
        clone1.setList(list1);
        return clone1;
    }
```

测试

```java
public class PrototypeTest {
    public static void main(String[] args) {
        // 浅克隆
        ShallowClone shallowClone = new ShallowClone();
        shallowClone.setName("小二");
        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        shallowClone.setList(list);

        try {
            ShallowClone clone = shallowClone.clone();
            System.out.println(clone.getList().get(0));
            // false 对象互不影响，改内容不会影响
            System.out.println(clone == shallowClone);    
            // true 表示两个List使用的是同一个，会相互影响
            System.out.println(shallowClone.getList()==clone.getList());  
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-------------------------------");

        // 深克隆
        DeepClone deepClone = new DeepClone();
        deepClone.setName("小王");
        ArrayList<String> deepList = new ArrayList<>();
        deepList.add("BBB");
        deepClone.setList(deepList);

        try {
            DeepClone clone = deepClone.clone();
            System.out.println(clone.getList().get(0));
            // false 深拷贝，两个list互不影响
            System.out.println(deepClone == clone);  
            // false 两个list互不影响
            System.out.println(deepClone.getList()==clone.getList());  
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
```



## 结构型模式

作用：如何将对象和类组成较大、更灵活的结构，虽然继承机制扩子类扩展父类的功能。

#### 适配器模式

定义统一的适配接口，把不兼容的接口做到统一，可以让两个没有关联的类一起运行。将一个类转换成客户希望的另外的一个接口。主要解决接口不兼容等问题，

当两个类做的事情相同或者类似，但是具有不同的接口时使用它， 客户端统一调用接口，在双方都不太容易修改时使用适配器模式匹配。 

场景：充电接口（万能充、数据线、转换头）
缺点：过多使用适配器会很凌乱，调用的是A接口，但实际上调用的是B接口

适配者接口：方法适配都是定义是否是首单，单具体的逻辑不同，然后让用户自己决定适配那个接口（转换器）

```java
public interface AdapterOrderService {
	// 定义是否是首单
    boolean isFirst(String uId);
}
```

适配的具体实现类

```java
public class InsideOrderService implements AdapterOrderService{

	// 内部商品的具体逻辑
    @Override
    public boolean isFirst(String uId) {
        return false;
    }
}

public class ThirdOrderService implements AdapterOrderService{
	// 第三方商品的具体逻辑
    @Override
    public boolean isFirst(String uId) {
        return true;
    }
}
```

测试

```java
public class AdaptorTest {
    public static void main(String[] args) {
        InsideOrderService service = new InsideOrderService();
        boolean result = service.isFirst("12");
        System.out.println("是否是首单" + result);
    }
}
```

#### 桥接模式

将抽象部分与实现部分分离，简单说A类接口中也含有B类接口，这个B类就是设计的桥。通过它可以减少子类的个数。微信密码和支付宝密码，这个密码就是桥。

场景：支付方式，支付由微信、支付宝 + 人脸、指纹、密码

定义验证**桥接接口**

```java
public interface IPayMode {

    boolean security(String uId);
}
```

定义验证方式：人脸、指纹、密码的主要逻辑

```java
public class PayCypher implements IPayMode{

    @Override
    public boolean security(String uId) {
        System.out.println("密码方式支付" + uId);
        return false;
    }
}

public class PayFaceMode implements IPayMode{

    @Override
    public boolean security(String uId) {
        System.out.println("刷脸支付" + uId);
        return false;
    }
}
```

定义支付类型抽象类

```java
public abstract class Pay {
    
	// 定义桥接接口IPayMode,并在构造函数中定义支付方式
    protected IPayMode payMode;
    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }
    
     //定义共同实现转账接口
    public abstract String transfer(String uId, BigDecimal amount);
}
```

定义具体实现类：微信支付宝具体逻辑

```java
public class WxPay extends Pay{

    public WxPay(IPayMode payMode) {
        super(payMode);
    }
    @Override
    public String transfer(String uId, BigDecimal amount) {
       return "微信支付";
    }
}

public class ZfbPay extends Pay{
    public ZfbPay(IPayMode payMode) {
        super(payMode);
    }
    @Override
    public String transfer(String uId, BigDecimal amount) {
        return "支付宝支付";
    }
}
```

测试

```java
public class BridgeTest {
    public static void main(String[] args) {
        WxPay pay = new WxPay(new PayFaceMode());
        String transfer = pay.transfer("1000", new BigDecimal(100));
        System.out.println("支付方式："+transfer);
    }
}
```

#### 组合模式

通过把相似的对象组合成一个可被调用的对象的设计思路称为组合模式

场景：文件系统、视图树、组织架构图

缺点：如果确定是特殊组织，然后做特殊操作，需要在运行时判断

抽象类或接口：定义同一的处理操作，该角色包含所有子类的共同行为的声明和实现

```java
public interface IFile {
    void display();
    boolean add(IFile iFile);
    boolean remove(IFile iFile);
    List<IFile> getChildren();
}
```

叶子构件：组合结构中表示叶子节点对象

```java
public class File implements IFile {

    private String name;

    public File(String name){
        this.name=name;
    }

    @Override
    public void display() {
        System.out.println(name);
    }

    @Override
    public boolean add(IFile iFile) {
        return false;
    }

    @Override
    public boolean remove(IFile iFile) {
        return false;
    }

    @Override
    public List<IFile> getChildren() {
        return null;
    }
}
```

容器构件(组合类)：容器接口可以包含子节点，子节点可以是叶子节点或容器节点

```java
public class Folder implements IFile {

    private String name;
    private List<IFile> list;

    public Folder(String name){
        this.name=name;
        list=new ArrayList<>();
    }

    @Override
    public void display() {
        System.out.println(name);
    }

    @Override
    public boolean add(IFile iFile) {
        return list.add(iFile);
    }

    @Override
    public boolean remove(IFile iFile) {
        return list.remove(iFile);
    }

    @Override
    public List<IFile> getChildren() {
        return list;
    }
}
```

测试

```java
public class test {
    public static void main(String[] args) {
        //c盘
        Folder folder=new Folder("C:");
        Folder folder1=new Folder("蓝桥杯");
        folder.add(folder1);
        File file2=new File("3.txt");
        folder1.add(file2);
        //文件
        File file=new File("1.txt");
        File file1=new File("2.txt");
        folder.add(file);
        folder.add(file1);

        Folder folder2=new Folder("大数据");
        Folder folder3=new Folder("Linux");
        folder2.add(folder3);
        folder3.add(file1);
        File file4=new File("4.txt");
        folder2.add(file4);
        folder1.add(file1);
        folder1.add(folder2);
        getAll(folder,0);
    }
}
```



#### 装饰器模式

在不改变原有类的基础上给类新增功能且不影响主类，同时按需运行时添加和删除这部分逻辑。通常扩展方法会创建子类然后扩展方法，使用装饰器可以减少子类的创建。

案例：俄罗斯套娃

场景：需要给类添加一个功能，且也可动态撤销

抽象构件角色：动态添加任务的对象接口

```java
public interface MileTea {
    String getName();
    double getPrice();
}
```

具体构件角色：定义要被装饰器装饰的对象（基类）

```java
public class CocoMileTea implements MileTea {
    @Override
    public String getName() {
        return "巧克力奶茶";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
public class QQMileTea implements MileTea{
    @Override
    public String getName() {
        return "QQ奶茶";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}

```

抽象装饰器：持有一个构件角色对象的实例，定义一个和抽象构件一致的接口，维护对组件和其子类组建的应用

```java
public  abstract class DecoratorTea implements MileTea {

    private MileTea mileTea;

    public DecoratorTea(MileTea mileTea) {
        this.mileTea = mileTea;
    }

    @Override
    public String getName() {
        return mileTea.getName();
    }

    @Override
    public double getPrice() {
        return mileTea.getPrice();
    }
}
```

具体装饰器角色：向组件添加新的职责

```java
public class Pearl extends DecoratorTea{
    public Pearl(MileTea mileTea) {
        super(mileTea);
    }

    @Override
    public String getName() {
        return super.getName()+"加入珍珠";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5;
    }
}
public class Pudding extends DecoratorTea {

    public Pudding(MileTea mileTea) {
        super(mileTea);
    }

    @Override
    public String getName() {
        return super.getName()+"加入布丁";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 10;
    }
}
public class Sugar extends DecoratorTea{

    public Sugar(MileTea mileTea) {
        super(mileTea);
    }

    @Override
    public String getName() {
        return super.getName()+"加入白糖";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 3;
    }
}
```

测试

```java
public class DecoratorTest {
    public static void main(String[] args) {
        MileTea milkTea = new CocoMileTea();
        // 第一次修饰，为巧克力奶茶添加布丁
        milkTea= new Pudding(milkTea);
        // 第二次修饰，为巧克力奶茶添加珍珠
        milkTea = new Pearl(milkTea);
        System.out.println(milkTea.getName()+"-总价"+milkTea.getPrice());
    }
}
```

#### 外观模式

> 又称门面模式（网关），解决了调用方的使用接口的复杂逻辑组合。对外提供交互接口，隐藏内部

**场景**：中间件，统一对外提供服务

**缺点**：不符合开闭原则、改写困难、继承和重写都不合适

定义三个子系统内部服务

```java
public class SystemA {
    public void doA(){
        System.out.println("系统A执行逻辑");
    }
}

public class SystemB {
    public void doB(){
        System.out.println("系统B执行逻辑");
    }
}

public class SystemC {
    public void doC(){
        System.out.println("系统C执行逻辑");
    }
}
```

定义统一的对外服务开关

```java
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

```

测试：

```java
public class FacadeTest {
    public static void main(String[] args) {
        FacadeWay facadeWay = new FacadeWay();
        // 系统ABC访问
        facadeWay.visit();

        // 系统BC访问
        facadeWay.BC();
    }
}
```

#### 享元模式

用于共享对象，减少内存使用，提升系统的访问效率，统一抽离作为共享对象使用,将复杂的对象抽出来一个公用的对象，减少对象的创建。

场景：当系统存在大量相似的对象，每个对象之间根据不同的场景有些许变化。

创建一个享元工厂，从池中获取管理对象

```java
public class ShapeFactory {
    // 定义一个池容器
    private static HashMap<String, Shape> pool = new HashMap<>();
    // 工厂：判断池中是否有对象，有对象则直接返回，没有则创建然后放在池中
    public static Shape getShape(String color) {
        Shape circle = pool.get(color);
        if (circle == null) {
            circle = new Circle();
            pool.put(color, circle);
            System.out.println("新创建一个circle对象-> 颜色为：" + color);
        }
        return circle;
    }
}
```

定义一个共享对象的接口

```
public interface Shape {
    void draw();
}
```

定义需要实现共享的类

```java
public class Circle implements Shape {

    private int d;
    public void setD(int d) {
        this.d = d;
    }
    @Override
    public void draw() {
        System.out.println("圆形周长：" + d);
    }
}
```

测试

```java
public class ShapeTest {
    private static final String colors[] ={ "Red", "Green", "Blue", "White", "Black" };
    public static void main(String[] args) {
      // 总共创建五个对象
        for (int i = 0; i < 20; i++) {
            Circle circle =  (Circle)ShapeFactory.getShape(getRandomColor());
            circle.setD(getRandomD());
            circle.draw();
        }
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomD() {
        return (int)(Math.random()*100 );
    }
}
```

#### 代理模式

为其他对象提供一种代理以控制这个对象的访问，在某些情况下，一个对象不能直接引用另一个对象，而代理可以在客户端和目标对象直接起到中介的作用。代理是一种不修改目标对象的前提下，通过代理对象访问目标对象。

场景：AOP动态代理

与适配器区别：适配器主要考虑对象的接口，而代理模式不能改变代理类的接口

与装饰器区别：装饰器为了增强功能，而代理是为了控制

代理模式是一项基本的设计技巧，许多其他模式，例如状态模式、策略模式、访问者模式本质也采用代理模式。

案例：黄牛买票，用户不直接去车站买票，直接找黄牛买，这个黄牛就是代理中介者。

创建抽象角色：声明真实对象和代理对象共同的接口

```java
 interface sail{

     void sailTicket();
}
```

实现目标对象：是业务逻辑的具体执行者。

```java
class sailTicket implements sail {

    @Override
    public void sailTicket() {
        System.out.println("车站售卖车票");
    }
}
```

静态代理对象：实际是调用车站卖票具体执行者的实现，也可扩展方法

```java
class sailProxy implements sail{
    public sailTicket ticket;

    public sailProxy(sailTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void sailTicket() {
        daZhe();
        youHuiQuan();

    }

    // 扩展代理对象
    public void daZhe(){
        System.out.println("打八折！");
    }
    public void youHuiQuan(){
        System.out.println("优惠券！");
    }
```

测试

```java
public class StaticProxyTest {
    public static void main(String[] args) {
        // 目标对象
        sailTicket sail = new sailTicket();
        // 定义中介代理对象
        sailProxy proxy = new sailProxy(sail);
        // 中介售卖车票
        proxy.sailTicket();

    }
}
```

缺点：由于增加代理对象，可能会造成请求过慢，而代理需要额外的工作，使代理变得复杂。由于代理对象和目标对象一致的接口，会产生过多的代理类，一旦目标对象接口增加方法，目标对象和代理对象都要添加方法。

**动态代理**

创建目标代理对象

```
interface sell{

    void recent();
}
```

创建真实对象

```java
class station implements sail{

    @Override
    public void sailTicket() {
        System.out.println("车站售卖场所");
    }
}
```

创建代理对象

```java
class DynamicProxy implements InvocationHandler{

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        coupon();
        method.invoke(object, args);
        cash();
        return object;
    }

    // 代理类扩展
    public void coupon(){
        System.out.println("优惠券打折");
    }

    public void cash(){
        System.out.println("现金付款");
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }
}
```

测试

```java
public class DynamicProxyTest {
    public static void main(String[] args) {
        station station = new station();
        // 创建代理对象把要代理的类传进去
        DynamicProxy proxy = new DynamicProxy(station); 
        sail sail = (design_structor_agency.sail) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                station.getClass().getInterfaces(), proxy); //这里注意要用父类接口接受
        sail.sailTicket();
    }
}
```

## 行为模式

作用：负责对象间的沟通或职责

#### 责任链模式

多个对象处理一个请求，动态指定一组对象处理请求或添加新的处理者，可以动态处理请求，如果自己无法请求就去下一级，直到有一个对象处理它为止。

案例：请假审批

抽象逻辑类：处理各个节点的处理方式

```java
interface Handle {

    Handler setNextHandle(Handle nextHandle);

    boolean handle(int amount);
}
```

定义抽象逻辑的具体实现类

```java
class leader extends Handler{
    private Handle nextHandle;

    @Override
    public Handler setNextHandle(Handle nextHandle) {
        this.nextHandle = nextHandle;
        return this;
    }

    @Override
    public boolean handle(int amount) {
        if (amount > 0 && amount < 10) {
            System.out.println("leader处理逻辑");
            return true;
        }
        // 处理不了，处理下一个节点
        return nextHandle.handle(amount);
    }
}
```

定义抽象的具体逻辑实现类

```java
class boss extends Handler{

    private Handle nextHandle;

    @Override
    public Handler setNextHandle(Handle nextHandle) {
        this.nextHandle = nextHandle;
        return this;
    }

    @Override
    public boolean handle(int amount) {
        if (amount > 10 && amount < 100) {
            System.out.println("Boss处理逻辑");
            return true;
        }
        return nextHandle.handle(amount);
    }
}
```

最终处理方式

```java
class master extends Handler{

       private Handle nextHandle;

    @Override
    public Handler setNextHandle(Handle nextHandle) {
        this.nextHandle = nextHandle;
        return this;
    }

    @Override
    public boolean handle(int amount) {
        if (amount > 100) {
            System.out.println("最后处理方式");
            return true;
        }
        // 没有处理方式了，直接返回false
        return false;
    }
}
```

测试

```java
public class ChainPattern {
    public static void main(String[] args) {
        leader leader = new leader();
        boss boss = new boss();
        master master = new master();
        leader.setNextHandler(boss).setNextHandler(master);
        // leader处理不了交给下一级boss,最后master处理
        leader.process(120);
    }
}
```



#### 命令模式

可以使用构造函数的方式传递给调用者，调用者再提供相应的的实现为命令执行提供操作的方法

缺点：具体的实现者过多

案例：小二下单

抽象命令类：声明执行命令的接口和方法

```java
public interface ICuisine {
    void cook();
}
```

具体的命令实现类（广东菜品、江苏菜品），在每个实现类都有一个厨师类，并通过这个类提供的方法进行炒菜操作

```java
public class GuangDoneCuisine implements ICuisine {
    private ICook iCook;
    public GuangDoneCuisine(ICook iCook) {
        this.iCook = iCook;
    }

    @Override
    public void cook() {
        iCook.doCooking();
    }
}
public class JiangSuCuisine implements ICuisine{
    private ICook cook;
    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
```

抽象实现者（厨师）为命令的实现者

```java
public interface ICook {
    void doCooking();
}
```

抽象具体实现者（具体厨师）也就是命令做实现的具体实现类

```java
public class JiangSuCook implements ICook{
    @Override
    public void doCooking() {
        System.out.println("江苏厨师做菜");
    }
}
public class GuangDongCook implements ICook{
    @Override
    public void doCooking() {
        System.out.println("广东厨师做菜");
    }
}
```

调用者：处理命令、实现的具体操作者、负责对外提供命令的服务（小二）

```java
public class XiaoEr {

    private List<ICuisine> cuisineList = new ArrayList<ICuisine>();
    public void order(ICuisine iCuisine) {
        cuisineList.add(iCuisine);
    }
    public synchronized void placeOrder(){
        for (ICuisine iCuisine : cuisineList) {
            iCuisine.cook();
        }
        cuisineList.clear();
    }
}
```

测试

```java
public class CookTest {
    public static void main(String[] args) {
        // 菜品和厨师结合，每个具体的命令都拥有一个对应的实现类，进行组合。
        GuangDoneCuisine doneCuisine = new GuangDoneCuisine(new GuangDongCook());
        JiangSuCuisine suCuisine = new JiangSuCuisine(new JiangSuCook());
        // 点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(doneCuisine);
        xiaoEr.order(suCuisine);

        xiaoEr.placeOrder();
    }
}
```

#### 迭代器模式

以相同的方式，遍历不同的数据结构元素，相当于`iterator`遍历，可以以相同的方式遍历不同的数据结构元素

场景：数组、链表、树等



#### 中介者模式

解决复杂功能应用之间的重复调用，在中间添加一层中介者包装服务，对外提供通用，易扩展的服务能力。统一对外处理具体逻辑，相当于网关的设计模式。AB直接需要通过C来传达

定义中介者：定义房东与租客之间通信

```java
public abstract class Mediator {

    // 进行卖家和买家联络
    public abstract void contact(String content, Trader trader);
}
```

定义抽象租客角色，使得子类可以和任意对象进行通信

```java
public abstract class Trader {
    private String name;
    protected Mediator mediator;

    public Trader(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public abstract void getMessage(String message);
    public void contact(String message) {
        mediator.contact(message, this);
    }
}
```

定义房东类和房客类：实现自己的通信方法

```java
public class HouseOwner extends Trader {

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("房主获取消息：" + message);
    }

    // 房主与中介通信
    public void contact(String message) {
        mediator.contact(message, this);
    }
}

public class Tenant extends Trader {

    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("房客获取消息:" + message);
    }


    @Override
    public void contact(String message) {
        mediator.contact(message, this);
    }
}
```

定义具体中间者，具体的中介对象，可以看到定义了房东信息和租房者的对象，通过中介对象，实现了房东直接直接的通信。

```java
public class ConcreteMediator extends Mediator{

    // 中介必须知道所有房主和房客的信息
    private HouseOwner houseOwner;
    private Tenant tenant;

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public void setTraderB(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void contact(String message, Trader trader) {
        if (trader == houseOwner) {
            tenant.getMessage(message);
        }
        if (trader == tenant) {
            houseOwner.getMessage(message);
        }
    }
}
```

测试

```java
public class MediatorTest {
    public static void main(String[] args) {
        // 定义具体中介者
        ConcreteMediator mediator = new ConcreteMediator();
        // 定义具体交易者房主和房客只需知道中介即可
        HouseOwner owner = new HouseOwner("张三", mediator);
        Tenant tenant = new Tenant("张三", mediator);
        // 中介者知晓每个具体的交易者
        mediator.setHouseOwner(owner);
        mediator.setTraderB(tenant);
        tenant.contact("你那里有房子要出租么");
        owner.contact("是的你需要出租么");
    }
}
```

#### 备忘录模式

可以进行回滚或恢复功能作为核心功能的设计模式，在功能实现是以不破环原对象增加备忘录操作，记录源对象行为实现备忘录模式。

案例：撤销回滚、快照、存档

备忘录信息（要保存的数据）

```java
public class Memento {
    // 备忘录姓名信息（可写保存对象）
    private String name;

    public Memento(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

负责人角色：主要负责保存备忘录对象

```java
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
```

发起人角色：包含当前状态的备忘录对象

```java
public class User {

    // 要保存的信息（姓名可写对象）
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 保存信息到备忘录
    public Memento saveToMemento(){
        return new Memento(name);
    }

    // 从备忘录中恢复状态
    public void restoreFromMemento(Memento memento) {
        name = memento.getName();
    }
}
```

测试

```java
public class MementoTest {
    public static void main(String[] args) {
        // 发起人角色
        User user = new User();
        // 负责人角色
        CareTaker careTaker = new CareTaker();
        user.setName("张三");
        user.setName("李四");
        // 保存状态到备忘录中
        careTaker.add(user.saveToMemento());  // 保存的是李四
        user.setName("王五");
        // 保存状态到备忘录
        careTaker.add(user.saveToMemento()); // 保存的是王五
        user.setName("老六");
        System.out.println("最近名称" + user.getName());

        // 恢复状态
        user.restoreFromMemento(careTaker.get(0));
        System.out.println("第一" + user.getName());
        user.restoreFromMemento(careTaker.get(1));
        System.out.println("第二" + user.getName());
    }
}
```

#### 观察者模式

当一个行为发生变化时，某些与他相关的对象也要随之做出改变，两者没有直接的耦合关联。一个对象改变自动通知其他对象。一对多关系。

场景：当一个对象依赖与另一个对象状态，及目标对象发生改变会直接影响到观察者。创建一个触发链A对象影响B，B影响C可以使用观察者链式触发机制。

缺点：当观察目标有多个直接或间接的观察者时，通知所有观察者过程会花费很多时间。当观察目标和观察者之间存在循环依赖，观察目标会触发它们之间的循环调用，可能会导致系统崩溃。观察者缺少响应机制，仅仅知道观察目标发生变化。

观察目标接口

```java
public class Subject {

    //观察者数组
    private Vector<Observer> oVector = new Vector<>();

    //增加一个观察者
    public void addObserver(Observer observer) {
        this.oVector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(Observer observer) {
        this.oVector.remove(observer);
    }

    //通知所有观察者
    public void notifyObserver(String state) {
        for(Observer observer : this.oVector) {
            observer.update(state);
        }
    }
}
```

具体实现业务：监听价格发生变化

```java
public class PriceSubject extends Subject{

    // 具体业务
    public void doSomething(){
        System.out.println("当价格发生变化");
    }
}
```

观察者：观察者一般是一个接口，每一个实现该接口都是具体的观察者

```java
public interface Observer {

    // 更新操作
    public void update(String state);
}
```

具体观察者（消息订阅），接受被观察者发送状态改变通知

```java
public class AdminObserver implements Observer{
    @Override
    public void update(String state) {
        System.out.println("admin收到消息的逻辑信息-"+state);
    }
}
public class ConsumerObserver implements Observer{
    @Override
    public void update(String state) {
        System.out.println("消费者收到消息的逻辑信息-" + state);
    }
}
```

测试：当一个对象被修改时，则会自动通知依赖它的对象

```java
public class ObserverTest {
    public static void main(String[] args) {
        // 创建一个主题
        PriceSubject subject = new PriceSubject();
        // 添加观察者
        AdminObserver observer = new AdminObserver();
        ConsumerObserver consumerObserver = new ConsumerObserver();

        // 添加观察者（订阅）
        subject.addObserver(observer);
        subject.addObserver(consumerObserver);


        // 取消订阅
        subject.deleteObserver(consumerObserver);
        // 添加监听活动
        subject.doSomething();
        // 通知所有观察者
        subject.notifyObserver("价格发生变化了！！");
    }
}
```


#### 状态模式

描述的一个行为下的多种状态变更，比如在不同的登录状态下，返回的页面是不同的，这个登录与不登录就是状态

定义状态抽象类：定义各个状态的处理流程

```java
public interface State {

    public void handle(String status);
}
```

定义状态的具体逻辑：发货状态、收货状态、订单状态

```java
public class DeliverState implements State{
    @Override
    public void handle(String status) {
        System.out.println("发货状态" + status);
    }
}

public class GainState implements State{
    @Override
    public void handle(String status) {
        System.out.println("收货状态" + status);
    }
}

public class OrderState implements State{

    @Override
    public void handle(String status) {
        System.out.println("订单状态" + status);
    }
}
```

定义环境上下文，内部维护一个当前状态并负责具体状态的切换

```java
public class Context {
    // 定义状态
    private State state;

    // 修改状态
    public void setState(State state) {
        this.state = state;
    }

    // 对状态进行管理，调用状态的具体业务逻辑方法
    public void handle(String status){
        state.handle(status);
    }
}
```

测试：创建环境上下文实例，由它决定调用那个方法

```java
public class StateTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new GainState());
        context.handle("2");
    }
}
```

#### 策略模式

一般是同类可替代的行为逻辑层，比如直减、满减、折扣、N元购，可以任选其中之一的方式。

场景：一般一个操作有好多中实现方式，而根据不同情况下使用`if-else`等分支决定使用哪找方式

缺点：策略过多增加，会造成子类过多，使用者必须知道所有的策略类

定义策略接口：规定算法的同一操作，定义同一的优惠券策略

```java
public interface CouponStrategy {

    public String disCount(int num1);
}
```

封装各个具体实现算法

```java
public class CashCoupon implements CouponStrategy{
    @Override
    public String disCount(int num1) {
        return "现金优惠";
    }
}

public class LotteryCoupon implements CouponStrategy{
    @Override
    public String disCount(int num1) {
        return "抽奖优惠";
    }
}

public class MemberCoupon implements CouponStrategy{
    @Override
    public String disCount(int num1) {
        return "会员优惠";
    }
}
```

策略上下文：外部可以传递不同的策略实现

```java
public class Context {
    private CouponStrategy strategy;

    public Context(CouponStrategy strategy) {
        this.strategy = strategy;
    }

    // 执行策略控制方法,统一的方法执行策略计算
    public String executeStrategy(int nums) {
        return strategy.disCount(nums);
    }
}
```

测试

```java
public class StrategyTest {
    public static void main(String[] args) {
        Context context = new Context(new LotteryCoupon());
        String result = context.executeStrategy(10);
        System.out.println("执行策略：" + result);
    }
}
```

#### 模板模式

控制整套逻辑的执行顺序和统一的输入和输出，比如做菜逻辑，控制整套的逻辑操作。可以控制整套逻辑，只要关注自己的业务逻辑即可。

缺点：每个不同的实现都需要子类实现，导致类的个数增加。

定义做饭逻辑步骤：把不变的逻辑封装在一起

```java
abstract class Cooking{
    protected abstract void step1();
    protected abstract void step2();
    protected abstract void step3();

    // 定义制作流程模板，定义final 防止子类重写
    final void cook(){
        System.out.println("做饭开始:");
        step1();
        step2();
        step3();
        System.out.println("做饭结束");
    }
}
```

做饭具体实现逻辑

```java
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
```

测试

```java
public class CookTest {
    public static void main(String[] args) {
        CookingTemplate cook = new CookingTemplate();
        cook.cook();
    }
}
```

#### 访问者模式

模拟同一个事物在不同的视角的访问信息不同，这就是访问者模式。

案例：成绩在不同访问者-下的不同信息，针对不同的访问者，访问的消息是不同的。

缺点：违法迪米特原则，因为具体元素对访问者公布细节，违反依赖倒置原则，依赖了具体类，没有依赖抽象。

定义抽象访问者角色，为每个具体元素类对应一个访问者

```java
public interface Visitor {

    // 学生访问
    void visit(Student student);

    // 老师访问
    void visit(Teacher teacher);
}
```

具体访问者：每个具体的访问者都有一个具体的访问逻辑。

```java
public class UserVisitor implements Visitor{

    @Override
    public void visit(Student student) {
        System.out.println("学生访问成绩的具体逻辑");
    }

    @Override
    public void visit(Teacher teacher) {
        System.out.println("老师访问成绩的具体逻辑");

    }
}
```

定义访问者抽象角色：定义接受访问者对象作为一个参数

```java
public interface  User {

    // 定义不同的访问者接口，通过次方法可以将自己交给visitor访问
    public void accept(Visitor visitor);
}
```

具体访问者元素：实现抽象角色提供的接受操作

```java
public class Student implements User{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public class Teacher implements User{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
```

测试

```java
public class VisitorTest {
    public static void main(String[] args) {
        Student student = new Student();
        UserVisitor userVisitor = new UserVisitor();
        userVisitor.visit(student);
    }
}
```

