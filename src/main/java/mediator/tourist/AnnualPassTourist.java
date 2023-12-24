package mediator.tourist;

import lombok.EqualsAndHashCode;

/**
 * 年卡会员
 */
@EqualsAndHashCode(callSuper = true)
public class AnnualPassTourist extends Tourist{

    public AnnualPassTourist(String name, Integer age) {
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
