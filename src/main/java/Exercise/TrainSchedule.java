package Exercise;

import java.util.List;

public class TrainSchedule {

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
            System.out.println("Train schedules are not available");
        }else{
            System.out.println("Train schedule are : ");
            do{
                System.out.println("Train is : " + current.trainName);
                System.out.println(" " + current.schedule);
                current = current.next;

            }while(current!=head);
        }
    }
}
