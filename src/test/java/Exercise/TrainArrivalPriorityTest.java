package Exercise;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class TrainArrivalPriorityTest {

    @Test
    void enqueueAndDequeue() {
       TrainArrivalPriority trainArrivalPriority = new TrainArrivalPriority();

        Station station1 = new Station("S02", "Station 02", 200);
        TrainArrival trainArrival1 = new TrainArrival("Express", station1);

        trainArrivalPriority.enqueue(trainArrival1);
        assertEquals(trainArrival1, trainArrivalPriority.dequeue());
    }

    @Test
    void isEmpty() {
        TrainArrivalPriority trainArrivalPriority = new TrainArrivalPriority();

        assertTrue(trainArrivalPriority.isEmpty());

        Station station1 = new Station("S02", "Station 02", 200);
        TrainArrival trainArrival1 = new TrainArrival("Express", station1);

        trainArrivalPriority.enqueue(trainArrival1);
        assertFalse(trainArrivalPriority.isEmpty());
    }
}