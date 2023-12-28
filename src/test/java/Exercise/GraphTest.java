package Exercise;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void traverseAndDisplay() {
        Graph graph = new Graph();
        Station station1 = new Station("S01", "Station 01", 100);
        Station station2 = new Station("S02", "Station 02", 200);
        Station station3 = new Station("S03", "Station 03", 300);
        Station station4 = new Station("S04", "Station 04", 400);
        Station station5 = new Station("S05", "Station 05", 500);

        graph.addConnection(station1, station2);
        graph.addConnection(station2, station3);
        graph.addConnection(station3, station4);
        graph.addConnection(station4, station5);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        graph.traverseAndDisplay(station2);

        System.setOut(System.out);

        String expectOutput = "Current Station is : Station 02\n" +
                "Connected Station is : Station 02\n" +
                "Connected Station is : Station 02\n" +
                "Current Station is : Station 01\n" +
                "Current Station is : Station 03\n" +
                "Connected Station is : Station 03\n" +
                "Current Station is : Station 04\n" +
                "Connected Station is : Station 04\n" +
                "Current Station is : Station 05\n";

        assertEquals(expectOutput + System.lineSeparator(), outContent.toString());
    }
}