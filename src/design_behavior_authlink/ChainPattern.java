package design_behavior_authlink;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月22日 9:27
 */

public class ChainPattern {
    public static void main(String[] args) {
        leader leader = new leader();
        boss boss = new boss();
        master master = new master();
        leader.setNextHandler(boss).setNextHandler(master);
        //boss.setNextHandler(leader);
        // leader处理不了交给下一级boss,最后master处理
        leader.process(120);

    }
}

// 抽象逻辑类
abstract class Handler{

    // 定义下个节点
    protected Handler nextHandler;

    // 处理下个节点
    public Handler setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return this;
    }

    // 定义共同的抽象方法
    public abstract void process(Integer info);
}

// 定义抽象的具体逻辑实现类
class leader extends Handler{

    @Override
    public void process(Integer info) {
        if (info < 10) {
            System.out.println("交给leader处理");
        }
        // 如果自己处理不了交给下一级
        nextHandler.process(info);

    }
}

// 定义抽象的具体逻辑实现类
class boss extends Handler{

    @Override
    public void process(Integer info) {
        if (10 < info && info < 50) {
            System.out.println("交给boss处理");
        }
        nextHandler.process(info);
    }
}

// 最终的处理方式
class master extends Handler{

    @Override
    public void process(Integer info) {
        if (info > 100) {
            System.out.println("交给master处理");
        }
    }
}
