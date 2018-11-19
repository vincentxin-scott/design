/**
 * 单例模式
 * @Author Vincentxin
 * @Date 2018/11/19
 */
public class SingletonDemo {
}


/**
 * 痴汉或者饿汉
 */
class GodEager {
    private static final GodEager god = new GodEager();//自有永有的神单例
    private GodEager() {
    }//构造方法私有化
    public static GodEager getInstance() {//请神方法公开化
        return god;
    }
}

/**
 * 懒汉
 */
class GodLazy {
    private volatile static GodLazy god;
    private GodLazy(){}
    public static GodLazy getInstance() {//庙是开放的不用排队进入
        if (god == null) {//如果头柱香未产生，这批抢香人进入堂内排队。
            synchronized(GodLazy.class){//同步代码快，GodLazy属于多线程共享资源 //把当前并发访问的共同资源作为同步监听对象
                if (god == null) {//只有头香造了神，其他抢香的白排队了
                    god = new GodLazy();
                }
            }
        }
        //此处头柱香产生后不必再排队
        return god;
    }
}