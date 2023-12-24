package mediator.tourist;

import lombok.Data;
import mediator.queue.AbstractQueue;

import java.util.Objects;

/**
 * 抽象的普通游客类
 */
@Data
public abstract class Tourist {
    private AbstractQueue queue;
    private String name;
    private Integer age;

    public Tourist(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tourist tourist = (Tourist) o;
        return Objects.equals(getName(), tourist.getName()) && Objects.equals(getAge(), tourist.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    // Out: 跳过排队
    public abstract void skipWait();

    // Out: 获取自己的队列位置
    public abstract Integer getMyPosition();

    // In: 结束排队
    public void finishWaiting() {
        System.out.println(name + "结束排队");
    }
}
