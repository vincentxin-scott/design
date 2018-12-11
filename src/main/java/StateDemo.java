/**
 * 状态模式
 * Created by Vincentxin
 * Date：2018/12/10
 */
public class StateDemo {

}
interface  State{
    public void switchOn(Switcher switcher);//开
    public void switchOff(Switcher switcher);//关
}

class On implements State{

    @Override
    public void switchOn(Switcher switcher) {
        System.out.println("WARN!!通电状态无需再开");
        return;
    }

    @Override
    public void switchOff(Switcher switcher) {
        switcher.setState(new Off());
        System.out.println("OK...灯灭");
    }
}

class Off implements  State{

    @Override
    public void switchOn(Switcher switcher) {
        switcher.setState(new On());
        System.out.println("OK...灯亮");
    }

    @Override
    public void switchOff(Switcher switcher) {
        System.out.println("WARN!!!断电状态无需再关");
        return;

    }
}
class Switcher{
    //开关的初始状态设置为关
    private State state=new Off();

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void switchOn(){
        state.switchOn(this);
    }
    public void switchOff(){
        state.switchOff(this);
    }
}
