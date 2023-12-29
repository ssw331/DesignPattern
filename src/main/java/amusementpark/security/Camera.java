package amusementpark.security;
/**
 * @author WWWsy
 * 实现安保设备接口的具体设备，安保系统还可以有很多种设备，可按需扩展
 */
public class Camera implements SecurityDevice{
    @Override
    public void turnOn() {
        System.out.println("摄像头已开启");
    }

    @Override
    public void turnOff() {
        System.out.println("摄像头已关闭");
    }
}
