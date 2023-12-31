package amusementpark.security;
/**
 * @author WWWsy
 */
public class TurnOffCommand implements Command{
    private final SecurityDevice device;

    public TurnOffCommand(SecurityDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        System.out.println("设备正在关闭，请勿断电");
        device.turnOff();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("设备已成功关闭");
    }
}
