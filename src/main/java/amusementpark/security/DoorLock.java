package amusementpark.security;
/**
 * @author WWWsy
 */
public class DoorLock implements SecurityDevice{
    @Override
    public void turnOn() {
        System.out.println("门禁系统已开启");
    }

    @Override
    public void turnOff() {
        System.out.println("门禁系统已关闭");
    }
}
