package Exercise;

public class TrainArrival implements Comparable<TrainArrival>{

    private String trainName;
    Station  currentStation;

    public TrainArrival(String trainName, Station currentStation) {
        this.trainName = trainName;
        this.currentStation = currentStation;
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

    @Override
    public int compareTo(TrainArrival other) {
        //High distance has high priority
        return Double.compare(other.currentStation.getDistanceFromStation(), this.currentStation.getDistanceFromStation());
    }
}
