package Races;

public class Horse {
    private String name;
    private double speed;
    private double distance;
    private double time;

    public Horse(String name) {
        this.name = name;
        this.speed = Math.random()*10;
        this.distance=0;
        this.time=0;
        System.out.println(speed);
    }

    public void doStep() {
        distance+=speed;
    }

    public double getDistance() {
        return distance;
    }
}
