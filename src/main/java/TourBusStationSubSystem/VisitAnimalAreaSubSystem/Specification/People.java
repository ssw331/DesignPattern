package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Specification;

/**
 * @title: People
 * @Author Xinyu Fang
 * @Date: 2022/12/10 11:35
 * @Version 1.0
 */
public class People {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private String identity;

    private String authority;

    private int age;

    public People(String name, String identity, int age) {
        this.name = name;
        this.identity = identity;
        this.age = age;

    }
    public People(String name, String identity, int age, String authority) {
        this(name, identity, age);
        this.authority = authority;
    }

}