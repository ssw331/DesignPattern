package interpreter;
/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 测试类，用于解释器模式功能的测试
 */
public class InterpreterPatternExample {
    public static void main(String[] args) {
        Expression customerExpression = new CustomerExpression();

        Context context = new Context();
        context.setCustomerInfo("ADULT",true);

        double ticketPrice = customerExpression.interpret(context);
        System.out.println("门票价格：" + ticketPrice);
    }
}