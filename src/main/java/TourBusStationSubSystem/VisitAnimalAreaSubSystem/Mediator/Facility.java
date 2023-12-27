package TourBusStationSubSystem.VisitAnimalAreaSubSystem.Mediator;

/**
 * @title: Facility
 * @Author Xinyu Fang
 * @Date: 2022/12/10 13:13
 * @Version 1.0
 */
public class Facility {
    private String name;
    private String location;
    private int capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    private int currentNum;

    public Facility(String name,  String location, int capacity, int currentNum) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.currentNum = currentNum;
    }


}