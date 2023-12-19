package interpreter;
/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 枚举类，用来枚举顾客的身份信息
 */
public enum CustomerType {
    CHILD(0.6),ADULT(1.0),OLD(0.6),VETERAN(0.0),DISABLED(0.5);
    private final double percent;
    CustomerType(Double percent){
        this.percent=percent;
    }
    public Double getPercent(){
        return percent;
    }
}
