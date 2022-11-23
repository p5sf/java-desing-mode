package design_structor_agency;

/**
 * @author YanZhao
 * @description 静态代理的实现：一个客户不想直接访问一个对象，这时可以用一个中介进行访问，这个中介就是代理
 * 代理模式是一种可以在不修改原有目标对象的前提下，通过代理对象访问目标对象，提供额外的操作来对目标对象的扩展
 * 缺点：由于代理对象和目标对象一致的接口，会产生过多的代理类，一旦目标对象接口增加方法，目标对象和代理对象都要添加方法
 * 案例：售票系统，去车站，也可以去黄牛买车票
 * 在这个案例 用户不用去车站买票，直接去黄牛买票，依然买到了票
 * @date 2022年11月22日 23:28
 */

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

// 目标对象
 interface sail{

     void sailTicket();
}

// 实现具体的目标对象
class sailTicket implements sail {

    @Override
    public void sailTicket() {
        System.out.println("售卖车票");
    }
}

// 静态代理对象 找黄牛售卖车票代理类并扩展方法
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


}


