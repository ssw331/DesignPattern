package miscellaneous.state;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  14:00
 * @description: 顾客
 */
public class Visitor {

    // 顾客状态
    private VisitorState state;

    public Visitor(VisitorState state) {
        this.state = state;
    }

    public void setState(VisitorState state) {
        this.state = state;
    }

    public void enterPark() {
        state.enterPark();
    }

    public void accessAttraction() {
        state.accessAttraction();
    }

    public void exitPark() {
        state.exitPark();
    }

}
