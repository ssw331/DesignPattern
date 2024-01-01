package amusementparkvisit.mediator;

import java.util.Date;
import java.util.HashMap;

/**
 * @title: QueueMediator
 * @Author Kexian Tang
 * @Date: 2023/12/15
 * @Version 1.0
 */
public class QueueMediator {
    public static HashMap<String, String> rideQueueInfo = new HashMap<>();

    /**
     * @Desc: 更新并显示游乐设施排队信息
     * @Param: 游乐设施名称和等待时间
     * @Return: 无
     */
    public static void updateQueueInfo(String rideName, int waitTime) {
        try {
            Thread.sleep(1000); // 模拟更新延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date().toString() + " : " + rideName + " 等待时间更新为 " + waitTime + " 分钟");
        rideQueueInfo.put(rideName, "等待时间：" + waitTime + "分钟");

        showQueueMonitorBoard();
    }

    /**
     * @Desc: 显示游乐设施排队信息监控板
     * @Param: 无
     * @Return: 无
     */
    public static void showQueueMonitorBoard() {
        System.out.println("==============================");
        System.out.println("        游乐设施排队监控板      ");
        for (String ride : rideQueueInfo.keySet()) {
            System.out.println(ride + " : " + rideQueueInfo.get(ride));
        }
        System.out.println("==============================");
    }
}

