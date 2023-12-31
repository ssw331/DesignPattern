package amusementparkvisit;


import amusementparkvisit.mediator.QueueMediator;
import amusementparkvisit.mediator.Ride;

/**
 * @title: MediatorPatternTest
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 */
public class MediatorPatternTest {
    public static void main(String[] args) {
        // 创建两个游乐设施
        Ride rollerCoaster = new Ride("过山车", 30);
        Ride merryGoRound = new Ride("旋转木马", 15);

        // 显示初始排队信息
        QueueMediator.showQueueMonitorBoard();

        // 更新游乐设施的排队时间
        rollerCoaster.setWaitTime(45);
        merryGoRound.setWaitTime(20);

        // 再次显示更新后的排队信息
        QueueMediator.showQueueMonitorBoard();
    }
}
