package design_structor_agency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author YanZhao
 * @description 动态代理的实现
 *
 * @date 2022年11月23日 11:12
 */

public class DynamicProxyTest {
    public static void main(String[] args) {
        station station = new station();
        DynamicProxy proxy = new DynamicProxy(station); // 创建代理对象把要代理的类传进去
        sail sail = (design_structor_agency.sail) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                station.getClass().getInterfaces(), proxy); //这里注意要用父类接口接受
        sail.sailTicket();
    }


}

// 目标对象
interface sell{

    void recent();
}

// 动态代理对象
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

// 实现代理对象
class station implements sail{

    @Override
    public void sailTicket() {
        System.out.println("车站售卖场所");
    }


}
