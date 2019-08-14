package created_mode;

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
 * 懒汉(双检锁/双重校验锁)
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

/**
 * 静态内部类
 * 因为 SingletonHolder 类没有被主动使用，只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。
 */
class GodInnerClass{
    private static class GodHolder{
       private static final GodInnerClass INSTANCE = new GodInnerClass();
    }

    private GodInnerClass(){

    }
    public static final GodInnerClass getInstance(){
        return GodHolder.INSTANCE;
    }
}

/**
 * 枚举类型
 */
enum Singleton {
    INSTANCE;
    public void whateverMethod() {
    }
}
