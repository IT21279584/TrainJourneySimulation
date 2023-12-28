package Exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TrainSchedule {
    static Logger logger = LoggerFactory.getLogger(TrainSchedule.class);
    public Train head = null;
    public Train tail = null;

    public void addTrain(String trainName, List<Station> schedule){
        Train newTrain = new Train(trainName, schedule);

        if(head == null){
            head = newTrain;
            tail = newTrain;
            newTrain.next = tail;
        }else{
            tail.next = newTrain;
            tail = newTrain;
            tail.next = head;
        }
    }

    public void displayTrains(){
        Train current = head;
        if(head == null){
            logger.info("Train schedules are not available");
        }else{
            do{
                System.out.println("Train is : " + current.trainName);
                System.out.println("Schedules ");
                current.schedule.stream().map(Station::getName).forEach(System.out::println);
                current = current.next;

            }while(current!=head);
        }
    }
}
