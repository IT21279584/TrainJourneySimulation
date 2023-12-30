package Exercise;

public class TrainArrival implements Comparable<TrainArrival>{

    private String trainName;
    private String time;
    Station  currentStation;

    public TrainArrival(String trainName, String time, Station currentStation) {
        this.trainName = trainName;
        this.currentStation = currentStation;
        this.time = time;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setCurrentStation(Station currentStation) {
        this.currentStation = currentStation;
    }

    public String getTrainName() {
        return trainName;
    }

    public Station getCurrentStation() {
        return currentStation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(TrainArrival other) {
        //High distance has high priority
        return Double.compare(other.currentStation.getDistanceFromStation(), this.currentStation.getDistanceFromStation());
    }
}
