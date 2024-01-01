package ticket.interpreter;

import ticket.flyweight.Ticket;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 终结符表达式类，用于解释顾客身份，得出门票价格
 */
public class CustomerExpression implements Expression {

    /* 普通票价格 */
    private double normalPrice = 100.0;
    /* VIP票价格 */
    private double VIPPrice = 80.0;

    @Override
    public double interpret(Context context, Ticket ticket) {
        normalPrice = ticket.getPrice();
        VIPPrice = normalPrice * 0.8;
        double tempPrice = context.isVIP() ? VIPPrice : normalPrice;
        return tempPrice * context.getCustomerType().getPercent();
    }
}
