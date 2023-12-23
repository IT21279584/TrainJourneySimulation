package Exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrackJourney {
    static Logger logger = LoggerFactory.getLogger(TrackJourney.class);

    private  double[][] adjacencyMatrix;

    private TrainSchedule trainSchedule;
    private TrainArrivalPriority arrivalPriorityQueue;

    public TrackJourney(double[][] adjacencyMatrix, TrainSchedule trainSchedule,
                        TrainArrivalPriority arrivalPriorityQueue) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.trainSchedule = trainSchedule;
        this.arrivalPriorityQueue = arrivalPriorityQueue;
    }

    public List<Station> findShortestPath(Station start, Station destination) {
        int startIndex = Integer.parseInt(start.getSid()) - 1;
        int destIndex = Integer.parseInt(destination.getSid()) - 1;

        int size = adjacencyMatrix.length;
        double[] distance = new double[size];
        int[] parent = new int[size];
        boolean[] visited = new boolean[size];

        Arrays.fill(distance, Double.MAX_VALUE);
        distance[startIndex] = 0;

        for (int i = 0; i < size - 1; i++) {
            int current = minDistance(distance, visited);
            visited[current] = true;

            for (int j = 0; j < size; j++) {
                if (!visited[j] && adjacencyMatrix[current][j] != 0 &&
                        distance[current] + adjacencyMatrix[current][j] < distance[j]) {
                    distance[j] = distance[current] + adjacencyMatrix[current][j];
                    parent[j] = current;
                }
            }
        }

        List<Station> path = reconstructPath(parent, destIndex, start);
        if (path.isEmpty() || path.get(0).getSid().equals(destination.getSid())) {
            logger.info("No path exists between the specified stations.");
            return Collections.emptyList();
        }
        return path;
    }

    private int minDistance(double[] distance, boolean[] visited) {
        double min = Double.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private List<Station> reconstructPath(int[] parent, int destinationIndex, Station start) {
        List<Station> path = new ArrayList<>();
        int current = destinationIndex;

        while (current != -1) {
            path.add(new Station(String.valueOf(current + 1), "Station " + (current + 1), 0));

            if (current == Integer.parseInt(start.getSid()) - 1) {
                break;
            }

            if (current < 0 || current >= parent.length) {
                break;
            }

            current = parent[current];
        }

        Collections.reverse(path);
        return path;
    }
    public void scheduleTrain(String trainName, List<Station> schedule) {
        trainSchedule.addTrain(trainName, schedule);
    }

    public void enqueueTrainArrival(String trainName, Station currentStation) {
        TrainArrival trainArrival = new TrainArrival(trainName, currentStation);
        arrivalPriorityQueue.enqueue(trainArrival);
    }

    public TrainArrival dequeueTrainArrival() {
        return arrivalPriorityQueue.dequeue();
    }

    public void displayTrainSchedules() {
        trainSchedule.displayTrains();
    }

}
