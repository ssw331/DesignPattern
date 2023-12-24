package mediator.tourist;

import lombok.EqualsAndHashCode;

/**
 * 普通游客
 */
@EqualsAndHashCode(callSuper = true)
public class NormalTourist extends Tourist {

    public NormalTourist(String name, Integer age) {
        super(name, age);
    }

    @Override
    public void skipWait() {
        getQueue().skipWait(this);
    }

    @Override
    public Integer getMyPosition() {
        return getQueue().getPosition(this);
    }
}
