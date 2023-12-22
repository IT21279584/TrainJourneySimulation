package Exercise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TrainSimulation {
//    static Logger logger = LoggerFactory.getLogger(TrainSimulation.class);
    public static void main(String[] args) {
        double adjMatrix[][] = {
                {0, 10, 0, 10, 0},
                {10, 0, 15, 10, 0},
                {0, 15, 0, 25, 0},
                {10, 10, 25, 0, 0},
                {0, 0, 0, 0, 0}
        };
        TrainSchedule trainSchedule = new TrainSchedule();
        TrainArrivalPriority arrivalPriorityQueue = new TrainArrivalPriority();
        TrackJourney trainJourney = new TrackJourney(adjMatrix, trainSchedule, arrivalPriorityQueue);

        // Schedule trains
        trainJourney.scheduleTrain("Express Train", Arrays.asList(new Station("1", "Station 1", 2), new Station("2", "Station 2", 5), new Station("3", "Station 3", 20)));
        trainJourney.scheduleTrain("Local Train", Arrays.asList(new Station("1", "Station 1", 9), new Station("2", "Station 2", 15)));

        ArrayList<String> stations = new ArrayList<>();
        System.out.println("------Available stations------");
        for (int i = 1; i <= adjMatrix.length; i++) {
            System.out.println("Station " + i);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start station: ");
        String startStationSid = scanner.nextLine();
        System.out.println("Enter end station: ");
        String endStationSid = scanner.nextLine();

        Station startStation = new Station(startStationSid, "Station " + startStationSid, 15);
        Station endStation = new Station(endStationSid, "Station " + endStationSid, 8);

        // Validate input
        if (Integer.parseInt(startStationSid) >= 1 && Integer.parseInt(endStationSid) <= adjMatrix.length) {
            List<Station> shortestPath = trainJourney.findShortestPath(startStation, endStation);

            System.out.println("Shortest path from " + startStation.getName() + " to " + endStation.getName() + ":");
            System.out.println("\n-------Path stations--------");

            shortestPath.stream().map(Station::getName).forEach(System.out::println);


        } else {
            System.out.println("Invalid input. Please enter valid station indices.");
        }

        scanner.close();


        // Display train schedules
        System.out.println("\n------Train Schedules------");
        trainJourney.displayTrainSchedules();

        // Simulate train arrivals
        trainJourney.enqueueTrainArrival("Express Train", new Station("2", "Station 2", 10));
        trainJourney.enqueueTrainArrival("Local Train", new Station("3", "Station 3", 20));

        // Dequeue train arrivals based on priority
        System.out.println("\n------Train Arrivals------");
        while (!arrivalPriorityQueue.isEmpty()) {
            TrainArrival trainArrival = trainJourney.dequeueTrainArrival();
            System.out.println("Train Name: " + trainArrival.getTrainName());
            System.out.println("Current Station: " + trainArrival.getCurrentStation().getName());
            System.out.println();
        }

    }
}