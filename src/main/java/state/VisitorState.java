package state;

/**
 * @program:DesignPattern
 * @author: Xiang Lei
 * @email: xiang.lei.se@foxmail.com
 * @time: 2023/12/19  13:54
 * @description: 与游客权限相关的各种行为 - 基类
 */
public interface VisitorState {

    void enterPark();  // 进入游乐园

    void accessAttraction();  // 访问游乐设施

    void exitPark();  // 离开游乐园

}
