package Exercise;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainScheduleTest {

    @Test
    void addTrain() {
        TrainSchedule trainSchedule = new TrainSchedule();

        List<Station> schedule = new ArrayList<>();
        schedule.add(new Station("S01", "Station 01", 100));
        schedule.add(new Station("S02", "Station 02", 200));
        schedule.add(new Station("S03", "Station 03", 300));
        schedule.add(new Station("S04", "Station 04", 400));

        //Test adding a train to an empty schedule
        trainSchedule.addTrain("Express", schedule);
        assertNotNull(trainSchedule.head);
        assertEquals("Express", trainSchedule.head.trainName);
        assertSame(trainSchedule.head, trainSchedule.tail);

        //Test adding a train to a schedule
        trainSchedule.addTrain("Local", schedule);
        assertNotNull(trainSchedule.tail);
        assertEquals("Local", trainSchedule.tail.trainName);
        assertNotSame(trainSchedule.head, trainSchedule.tail);
    }

    @Test
    void displayTrains() {
        TrainSchedule trainSchedule = new TrainSchedule();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        List<Station> schedule = new ArrayList<>();
        schedule.add(new Station("S01", "Station 1", 100));
        schedule.add(new Station("S02", "Station 2", 200));
        schedule.add(new Station("S03", "Station 3", 300));

        //Test adding a train to an empty schedule
        trainSchedule.addTrain("Express Train", schedule);
        trainSchedule.displayTrains();
        System.setOut(System.out);

        String expectedOutput = "Train is : Express Train\n" +
                "Schedules \n" +
                "Station 1\n" +
                "Station 2\n" +
                "Station 3\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}