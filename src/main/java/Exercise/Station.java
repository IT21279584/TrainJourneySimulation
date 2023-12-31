package Exercise;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String sid;
    private String name;
    private double distanceFromStation;
    private List<Station> connectStation;

    public Station(String sid, String name, double distanceFromStation) {
        this.sid = sid;
        this.name = name;
        this.distanceFromStation = distanceFromStation;
        this.connectStation = new ArrayList<>();

    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistanceFromStation(double distanceFromStation) {
        this.distanceFromStation = distanceFromStation;
    }

    public void setConnectStation(Station connectStation) {
        getConnectStation().add(connectStation);
    }

    public String getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public double getDistanceFromStation() {
        return distanceFromStation;
    }

    public List<Station> getConnectStation() {
        return connectStation;
    }
}
