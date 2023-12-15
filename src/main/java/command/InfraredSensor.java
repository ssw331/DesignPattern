package command;
/**
 * @author WWWsy
 */
public class InfraredSensor implements SecurityDevice {
    @Override
    public void turnOn() {
        System.out.println("红外感应装置已启动");
    }

    @Override
    public void turnOff() {
        System.out.println("红外感应装置已关闭");
    }
}
