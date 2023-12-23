package Exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardingQueueTest {

    @Test
    void enqueueAndPassenger() {
        BoardingQueue boardingQueue = new BoardingQueue();
        Passenger passenger = new Passenger("Hansaka");

        boardingQueue.enqueuePassenger(passenger);
        assertEquals(passenger, boardingQueue.dequeuePassenger());
        assertEquals(null, boardingQueue.dequeuePassenger());
    }
}