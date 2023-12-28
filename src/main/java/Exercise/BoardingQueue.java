package Exercise;

import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;
import org.slf4j.Logger;

public class BoardingQueue {
    Queue<Passenger> passengerQueue;
    static Logger logger = LoggerFactory.getLogger(BoardingQueue.class);

    public BoardingQueue(){
        this.passengerQueue = new LinkedList<>();
    }

    public void enqueuePassenger(Passenger passenger){
        passengerQueue.offer(passenger);
        System.out.println(passenger.getName()+" has joined the boarding queue");
    }

    public Passenger dequeuePassenger(){
        Passenger nextPassenger = passengerQueue.poll();

        if (nextPassenger != null){
            System.out.println(nextPassenger.getName()+" has boarded the train");
        }else{
            logger.info("Queue is empty");
        }
        return nextPassenger;
    }

}
