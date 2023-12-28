package Exercise;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsCollectorTest {

    @Test
    void updateStatistics() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        StatisticsCollector statisticsCollector = new StatisticsCollector();
        BoardingQueue boardingQueue = new BoardingQueue();

        statisticsCollector.updateStatistics(boardingQueue, "Station 01");
        System.setOut(System.out);

        String expectedOutput = "\n------ Simulation Statistics ------\n" +
                "Stations Visited: 1\n" +
                "Total Boarded Passengers: 0\n" +
                "Passengers at Each Station: {Station 01=0}\n" +
                "-----------------------------------\n";
        assertEquals(expectedOutput, outContent.toString());




    }
}