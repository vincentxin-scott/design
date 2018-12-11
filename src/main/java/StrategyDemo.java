/**
 * 策略模式
 * Created by Vincentxin
 * Date：2018/12/10
 */
public class StrategyDemo {
}

interface Strategy{ //算法标准
    public int calculate(int a,int b);//操作数，被操作数
}

/**
 * 加法策略
 */
class Addition implements Strategy{

    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}

/**
 * 减法策略
 */
class Subtraction implements Strategy{

    @Override
    public int calculate(int a, int b) {
        return a-b;
    }
}

/**
 * 计算器类
 */
class Calculator{
    private Strategy strategy;//拥有某种算法策略

    public void  setStrategy(Strategy strategy){
        this.strategy=strategy;
    }
    public int getResult(int a,int b){
        return this.strategy.calculate(a,b);//返回具体策略的结果
    }
}

class Client{
    public static void main(String[] args) {
        Calculator calculator=new Calculator();//实例化计算器
        calculator.setStrategy(new Addition());//接入加法实现
        int result=calculator.getResult(1,2);
        System.out.println(result);

        calculator.setStrategy(new Subtraction());
        result=calculator.getResult(3,1);
        System.out.println(result);
    }
}