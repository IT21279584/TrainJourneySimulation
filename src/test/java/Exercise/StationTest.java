package Exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @Test
    void setSid() {
        Station station = new Station("S01", "Station 01", 200);
        station.setSid("S01");

        assertEquals("S01", station.getSid());
    }

    @Test
    void setDistanceFromStation() {
        Station station = new Station("S01", "Station 01", 200);
        station.setDistanceFromStation(200);

        assertEquals(200, station.getDistanceFromStation());
    }

    @Test
    void setName() {
        Station station = new Station("S01", "Station 01", 200);
        station.setName("Station 01");

        assertEquals("Station 01", station.getName());
    }

    @Test
    void setConnectStation() {
        Station station = new Station("S01", "Station 01", 200);
        station.setConnectStation(station);

        assertTrue(station.getConnectStation().add(station));
    }
}