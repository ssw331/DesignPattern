package interpreter;

/*
 * @Author XiaoJunLv
 * @Date 2023/12/19
 * */
/* *
 * 上下文类，保存了一些需要的信息，如顾客身份信息等
 */
class Context {
    private CustomerType customerType;
    private boolean isVIP;
    public void setCustomerInfo(String customerType,boolean isVIP) {
        try {
            switch (customerType) {
                case "CHILD":
                    this.customerType = CustomerType.CHILD;
                    break;
                case "ADULT":
                    this.customerType = CustomerType.ADULT;
                    break;
                case "OLD":
                    this.customerType = CustomerType.OLD;
                    break;
                case "VETERAN":
                    this.customerType = CustomerType.VETERAN;
                    break;
                case "DISABLED":
                    this.customerType = CustomerType.DISABLED;
                    break;
                default:
                    throw new CustomerTypeError("非法的顾客身份：" + customerType);
            }
        } catch (CustomerTypeError e) {
            System.out.println("Caught CustomerTypeException: " + e.getMessage());
        }
        this.isVIP=isVIP;
        return;
    }
    public boolean isVIP(){
        return isVIP;
    }
    public CustomerType getCustomerType(){
        return customerType;
    }
}
