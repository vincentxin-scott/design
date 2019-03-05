/**
 * 模板方法
 * Created by Vincentxin
 * Date：2019/3/5
 */
public class TemplateMethodDemo {

    public static void main(String[] args) {
        GPS gps=new GPS();
        gps.electrifyDC16V();
        CigarLighter cigarLighter=new CigarLighter();
        cigarLighter.electrifyDC16V();
        System.out.println("........................");
        Human human=new Human();
        human.move();
        human.feedMilk();
        Whale whale=new Whale();
        whale.move();
        whale.feedMilk();
        Bat bat=new Bat();
        bat.move();
        bat.feedMilk();
    }


}
/**
 * 点烟器接口
 */
interface CigarLighterInterface{
    //供电方法
    public void electrifyDC16V();
}

class GPS implements CigarLighterInterface{

    @Override
    public void electrifyDC16V() {
        System.out.println("连接卫星。。。");
        System.out.println("定位。。。。。");
    }
}

 class CigarLighter implements CigarLighterInterface{

    @Override
    public void electrifyDC16V() {
        int time=1000;
        while (--time>0){
            System.out.println("加热电炉丝");
        }
        System.out.println("点烟器弹出");
    }
}

abstract class Mammal{
    boolean female=false;
    //既然是哺乳动物当然会喂奶了，但这里约束为只能母的喂奶
    protected final void feedMilk(){
        if (female){//如果是母的
            System.out.println("喂奶");
        }else{
            System.out.println("公的不会");
        }
    }
    //哺乳动物当然可以移动，但是具体怎么移动还不知道
    public abstract void move();
}

class Human extends Mammal{
    public Human() {
        super.female=true;
    }

    @Override
    public void move() {
        System.out.println("两条腿走路");
    }
}

class Whale extends Mammal{
    {
        super.female=true;
    }
    @Override
    public void move() {
        System.out.println("游泳。。。");
    }
}

class Bat extends Mammal {

    @Override
    public void move() {
        System.out.println("用翅膀飞……");
    }

}