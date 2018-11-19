/**
 * 适配器模式
 * @Author Vincentxin
 * @Date 2018/11/19
 */
public class AdapterDemo {
}

/**
 * 三插孔标准通电
 */
interface TriplePin{
    //参数分别为火线live 零线null，地线earth

    public void electrify(int l,int n,int e);
}

/**
 * 两插孔标准通电
 */
interface DualPin{
    //参数是火线live 零线null
    public void electrify(int l,int n);
}

/**
 * 墙上的是的三插孔的标准通电插口，电视实现的是两口。
 */
class TV implements DualPin{

    @Override
    public void electrify(int l, int n) {
        System.out.println("火线通电"+l);
        System.out.println("零线通电"+n);
    }
}

/**
 * 这个适配器叫对象适配器
 * 里面包含一个双插接口的
 */
class Adapter implements TriplePin{
    private DualPin dualPin;
    //创建适配器的时候，需要把双插设备介入进来
    public Adapter(DualPin dualPin){
        this.dualPin=dualPin;
    }

    //适配器实现的是目标接口
    @Override
    public void electrify(int l, int n, int e) {

        //实际上调用了被适配设备的双插通电，地线e被丢弃了
        dualPin.electrify(l,n);
    }
}

/**
 * 这个适配器叫做类适配器
 * 此时这个适配器继承了TV 也就只能是TV的儿子用了，其他就用不了了。
 */
class ClassAdapter extends TV implements TriplePin{

    @Override
    public void electrify(int l, int n, int e) {
        super.electrify(l,n);
    }
}