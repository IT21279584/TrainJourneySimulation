package Exercise;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    @Test
    void displayStations() {
        Track track = new Track();
        Station station = new Station("S01", "Station 01", 200);
        Track.Node node = new Track.Node(station);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        track.displayStations();
        System.setOut(System.out);

        assertEquals("", outContent.toString());
    }
}