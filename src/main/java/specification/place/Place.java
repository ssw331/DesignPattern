package specification.place;

import specification.person.Person;

/**
 * 抽象的地点类，是所有地点的基类
 */
public abstract class Place {

    /**
     * 是否可以入内
     */
    public boolean canEnter(Person person){
        return true;
    }

}
