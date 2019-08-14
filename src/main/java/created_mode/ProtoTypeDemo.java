package created_mode;

/**
 * 通过打飞机游戏来学习原型模式
 *
 * @Author Vincentxin
 * @Date 2018/11/19
 */
public class ProtoTypeDemo {
}

/**
 * 子弹
 */
class Bullet implements Cloneable{
    @Override
    protected Bullet clone() throws CloneNotSupportedException {
        return (Bullet) super.clone();
    }
}

/**
 * 敌机
 */
class EnemyPlane implements Cloneable {//此处实现克隆接口
    private Bullet bullet=new Bullet();//敌机携带的子弹
    private int x;//敌机横坐标
    private int y = 0;//敌机纵坐标

    public EnemyPlane(int x) {//构造器
        this.x = x;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void fly() {//让飞机飞
        y++;//每调用一次，敌飞行时纵坐标+1

    }

    //此处开放setX，为了让克隆后的实例重新修改x坐标。
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 重写克隆方法
     * 克隆存在浅拷贝和深拷贝
     * 浅拷贝：只是拷贝原始类型的值，比如x,y的值都会被拷贝到克隆对象中，对于对象也会被拷贝，但是拷贝的就只用引用地址（指向容一个对象不合理）。
     *
     */
    @Override
    protected EnemyPlane clone() throws CloneNotSupportedException {
         EnemyPlane clonePlane=(EnemyPlane) super.clone();
         clonePlane.setBullet(this.bullet.clone());//深度拷贝子弹
         return clonePlane;
    }
}


class EnemyPlaneFactory{
    //此处用饿汉模式遭一个敌机原型
    private static  EnemyPlane protoType=new EnemyPlane(200);
    //获取敌机克隆实例
    public static EnemyPlane getInstance(int x) throws CloneNotSupportedException {
        EnemyPlane clone=protoType.clone();//复制原型机,先克隆除了敌机，子弹还没有进行克隆。
        clone.setX(x);//重新设置克隆机的x坐标
        return clone;
    }
}
