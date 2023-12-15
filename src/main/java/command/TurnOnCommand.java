package command;
/**
 * @author WWWsy
 * 实现命令接口的具体命令
 */
public class TurnOnCommand implements Command {
    private final SecurityDevice device;

    public TurnOnCommand(SecurityDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        System.out.println("设备正在启动");
        device.turnOn();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("设备已成功启动");
    }
}
