package Exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainArrivalTest {

    @Test
    void setTrainName() {
        Station station = new Station("S03", "Station 03", 200);
        TrainArrival trainArrival = new TrainArrival("Express", station);

        trainArrival.setTrainName("Express");
        assertEquals("Express", trainArrival.getTrainName());
    }

    @Test
    void setCurrentStation() {
        Station station = new Station("S03", "Station 03", 200);
        TrainArrival trainArrival = new TrainArrival("Express", station);

        trainArrival.setCurrentStation(station);
        assertEquals("Station 03", trainArrival.getCurrentStation().getName());
    }

    @Test
    void compareTo() {
        Station station1 = new Station("S02", "Station 02", 200);
        TrainArrival trainArrival1 = new TrainArrival("Express", station1);

        Station station2 = new Station("S03", "Station 03", 300);
        TrainArrival trainArrival2 = new TrainArrival("Express", station2);

        assertTrue(trainArrival1.compareTo(trainArrival2) > 0);
        assertTrue(trainArrival2.compareTo(trainArrival1) < 0);

        trainArrival1.getCurrentStation().setDistanceFromStation(300);
        assertEquals(0, trainArrival2.compareTo(trainArrival1));
    }
}