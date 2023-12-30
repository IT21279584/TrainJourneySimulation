package Exercise;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrackJourneyTest {

    double adjMatrix[][] = {
            {0, 10, 0, 10, 0},
            {10, 0, 15, 10, 0},
            {0, 15, 0, 25, 0},
            {10, 10, 25, 0, 0},
            {0, 0, 0, 0, 0}
    };
    TrainSchedule trainSchedule = new TrainSchedule();
    LocalDateTime localDateTime = LocalDateTime.now();



    @Test
    void findShortestPath() {

        List<Station> schedule = new ArrayList<>();
        schedule.add(new Station("1", "Station 01", 100));
        schedule.add(new Station("2", "Station 02", 200));
        schedule.add(new Station("3", "Station 03", 300));
        schedule.add(new Station("4", "Station 04", 400));
        schedule.add(new Station("5", "Station 05", 400));

        TrainArrivalPriority trainArrivalPriority = new TrainArrivalPriority();

        Station station2 = new Station("2", "Station 02", 200);
        Station station5 = new Station("5", "Station 05", 500);
        TrainArrival trainArrival1 = new TrainArrival("Express", String.valueOf(localDateTime), station2);

        TrackJourney trackJourney = new TrackJourney(adjMatrix, trainSchedule,trainArrivalPriority);


        List<Station> shortestPath = trackJourney.findShortestPath(station2, station5);

        assertEquals(3, shortestPath.size());
        assertEquals("Station 2", shortestPath.get(0).getName());
        assertEquals("Station 1", shortestPath.get(1).getName());
        assertEquals("Station 5", shortestPath.get(2).getName());

    }

    @Test
    void scheduleTrain(){

        List<Station> schedule = new ArrayList<>();
        schedule.add(new Station("1", "Station 01", 100));
        schedule.add(new Station("2", "Station 02", 200));
        schedule.add(new Station("3", "Station 03", 300));
        schedule.add(new Station("4", "Station 04", 400));

        TrainArrivalPriority trainArrivalPriority = new TrainArrivalPriority();
        TrackJourney trackJourney = new TrackJourney(adjMatrix, trainSchedule,trainArrivalPriority);

        trackJourney.scheduleTrain("Express", schedule);
        assertNotNull(trainSchedule.head);
        assertEquals("Express", trainSchedule.head.trainName);
        assertSame(trainSchedule.head, trainSchedule.tail);
    }

    @Test
    void dequeueAndenqueue(){
        TrainArrivalPriority trainArrivalPriority = new TrainArrivalPriority();

        Station station1 = new Station("S02", "Station 02", 200);
        TrackJourney trackJourney = new TrackJourney(adjMatrix, trainSchedule,trainArrivalPriority);

        trackJourney.enqueueTrainArrival("Express", String.valueOf(localDateTime), station1);
        assertEquals("Express", trackJourney.dequeueTrainArrival().getTrainName());
    }

    @Test
    void displayTrainSchedules(){
        TrainArrivalPriority trainArrivalPriority = new TrainArrivalPriority();

        TrainSchedule trainSchedule = new TrainSchedule();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Station station1 = new Station("S02", "Station 02", 200);
        TrackJourney trackJourney = new TrackJourney(adjMatrix, trainSchedule,trainArrivalPriority);

        String expectedOutput = "Train is : Express Train\n" +
                "Schedules \n" +
                "Station 1\n" +
                "Station 2\n" +
                "Station 3\n";

        assertDoesNotThrow(()->trackJourney.displayTrainSchedules());
        System.setOut(System.out);

    }
}