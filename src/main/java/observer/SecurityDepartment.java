package observer;

import command.*;
/**
 * @author WWWsy
 */
class SecurityDepartment implements Observer {
    private final SecurityControl control = new SecurityControl();
    @Override
    public void update(String facilityName, String status) {
        if ("故障".equals(status)) {
            System.out.println("安保部门收到 " + facilityName + " 故障的通知，正在前往维护现场秩序...");
        }else if ("运行中".equals(status)) {
            // 和命令模式的安保系统联动一下
            System.out.println("安保部门收到 " + facilityName + " 开始运行的通知，正在开启所有相关安保设施");

            SecurityDevice camera = new Camera();
            SecurityDevice infraredSensor = new InfraredSensor();
            SecurityDevice doorLock = new DoorLock();

            Command turnOnCamera = new TurnOnCommand(camera);
            Command turnOnInfraredSensor = new TurnOnCommand(infraredSensor);
            Command turnOnDoorLock = new TurnOnCommand(doorLock);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            control.setCommand(turnOnCamera);
            control.setCommand(turnOnDoorLock);
            control.setCommand(turnOnInfraredSensor);
            control.pressButton();

        }
    }
}
