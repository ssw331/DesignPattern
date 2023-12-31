package amusementpark.attraction;

public class RollerCoaster implements Attraction{
    private boolean safetyBeltFastened=false;

    @Override
    public void prepare() {
        // 模拟系安全带的过程
        System.out.println("正在系安全带...");
        this.safetyBeltFastened = true;
    }

    @Override
    public boolean isSafetyChecked() {
        return this.safetyBeltFastened;
    }
}
