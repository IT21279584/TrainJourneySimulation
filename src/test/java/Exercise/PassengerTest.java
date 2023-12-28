package Exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    void setName() {
        Passenger passenger = new Passenger("Hansaka");
        passenger.setName("Hansaka");

        assertEquals("Hansaka", passenger.getName());
    }
}