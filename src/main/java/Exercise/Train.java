package Exercise;

import java.util.List;

public class Train {
    String trainName;
    List<Station> schedule;
    Train next;

    public Train(String trainName, List<Station> schedule) {
        this.trainName = trainName;
        this.schedule = schedule;
    }
}
