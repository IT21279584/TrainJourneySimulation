package Exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrainArrivalPriority {
    private PriorityQueue<TrainArrival> priorityQueue;

    public TrainArrivalPriority() {
        this.priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void enqueue(TrainArrival trainArrival){
        priorityQueue.offer(trainArrival);
    }

    public TrainArrival dequeue(){
        return priorityQueue.poll();
    }

    public  boolean isEmpty(){
        return priorityQueue.isEmpty();
    }
}
