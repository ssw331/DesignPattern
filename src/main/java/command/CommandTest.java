package command;


import java.util.Scanner;
/**
 * @author WWWsy
 */
public class CommandTest {
    public static void main(String[] args) {
        // 创建安保设备
        SecurityDevice camera = new Camera();
        SecurityDevice infraredSensor = new InfraredSensor();
        SecurityDevice doorLock = new DoorLock();

        // 创建命令
        Command turnOnCamera = new TurnOnCommand(camera);
        Command turnOffCamera = new TurnOffCommand(camera);
        Command turnOnInfraredSensor = new TurnOnCommand(infraredSensor);
        Command turnOffInfraredSensor = new TurnOffCommand(infraredSensor);
        Command turnOnDoorLock = new TurnOnCommand(doorLock);
        Command turnOffDoorLock = new TurnOffCommand(doorLock);

        // 创建一个命令的调用者
        SecurityControl control = new SecurityControl();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你想要执行的操作：");
            System.out.println("1. 打开摄像头");
            System.out.println("2. 关闭摄像头");
            System.out.println("3. 打开红外线感应器");
            System.out.println("4. 关闭红外线感应器");
            System.out.println("5. 打开门锁");
            System.out.println("6. 关闭门锁");
            System.out.println("7. 退出");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    control.setCommand(turnOnCamera);
                    break;
                case 2:
                    control.setCommand(turnOffCamera);
                    break;
                case 3:
                    control.setCommand(turnOnInfraredSensor);
                    break;
                case 4:
                    control.setCommand(turnOffInfraredSensor);
                    break;
                case 5:
                    control.setCommand(turnOnDoorLock);
                    break;
                case 6:
                    control.setCommand(turnOffDoorLock);
                    break;
                case 7:
                    System.out.println("退出系统...");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效的输入，请重新输入！");
                    continue;
            }
            System.out.println("正在执行操作...");
            control.pressButton();
        }
    }
}
