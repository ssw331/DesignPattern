package amusementpark.security;
import amusementpark.workers.*;
public class SecurityControl implements Observer{
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    @Override
    public void update(String facilityName, String status) {
        if ("设施关闭".equals(status)) {
            System.out.println("安保部门收到 " + facilityName + " 关闭的通知，正在关闭相关机器");
            pressButton();
        }
    }
}
