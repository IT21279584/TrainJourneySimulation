package Exercise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.*;

public class TrainSimulation {
    static Logger logger = LoggerFactory.getLogger(TrainSimulation.class);
    public static void main(String[] args) {
        double adjMatrix[][] = {
                {0, 10, 0, 10, 0},
                {15, 0, 15, 0, 0},
                {0, 15, 0, 25, 0},
                {10, 10, 25, 0, 20},
                {0, 0, 0, 15, 0}
        };

        TrainSchedule trainSchedule = new TrainSchedule();
        TrainArrivalPriority arrivalPriorityQueue = new TrainArrivalPriority();
        TrackJourney trainJourney = new TrackJourney(adjMatrix, trainSchedule, arrivalPriorityQueue);
        LocalDateTime localTime = LocalDateTime.now();

        // Schedule trains
        trainJourney.scheduleTrain("Express Train", Arrays.asList(new Station("1", "Station 1", 2), new Station("2", "Station 2", 5), new Station("3", "Station 3", 20)));
        trainJourney.scheduleTrain("Local Train", Arrays.asList(new Station("1", "Station 1", 9), new Station("2", "Station 2", 15)));
        trainJourney.scheduleTrain("Local Train", Arrays.asList(new Station("5", "Station 5", 19), new Station("6", "Station 6", 15)));

        Train pq = new Train();
        TrainQueue trainQueue = new TrainQueue();

        List<Integer> stations = new ArrayList<>();

        // Create a HashMap to store station indices and names
        Map<Integer, String> stationMap = new HashMap<>();

        System.out.println("------Available stations------");
        for (int i = 1; i <= adjMatrix.length; i++) {
            System.out.println("Station " + i);
            stations.add(i);
        }
        System.out.println();
        printMatrix(adjMatrix, stations);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start station: ");
        String startStationSid = scanner.nextLine();
        System.out.println("Enter end station: ");
        String endStationSid = scanner.nextLine();

        Station startStation = new Station(startStationSid, "Station " + startStationSid, 15);
        Station endStation = new Station(endStationSid, "Station " + endStationSid, 8);

        // Validate input
        List<Station> shortestPath = null;
        if (Integer.parseInt(startStationSid) >= 1 && Integer.parseInt(endStationSid) <= adjMatrix.length) {
            shortestPath = trainJourney.findShortestPath(startStation, endStation);

            System.out.println("Shortest path from " + startStation.getName() + " to " + endStation.getName() + ":");
            System.out.println("\n-------Path stations--------");

            // List<String> stationNames = shortestPath.stream().map(Station::getName).collect(Collectors.toList());
            shortestPath.stream().map(Station::getName).forEach(System.out::println);

            //  System.out.println("Station List : " + stationNames);

        } else {
            logger.info("Invalid input. Please enter valid station indices.");
        }

        scanner.close();

        Track newTrack = new Track();
        newTrack.displayStations();

        // Display train schedules
        System.out.println("\n------Train Schedules------");
        trainJourney.displayTrainSchedules();

        // Simulate train arrivals
        trainJourney.enqueueTrainArrival("Express Train", String.valueOf(localTime), new Station("2", "Station 2", 10));
        trainJourney.enqueueTrainArrival("Local Train", String.valueOf(localTime.plusHours(2)), new Station("3", "Station 3", 20));
        trainJourney.enqueueTrainArrival("Ruhunu Train", String.valueOf(localTime.plusHours(2)), new Station("3", "Station 3", 20));
        trainJourney.enqueueTrainArrival("New Lanka Train", String.valueOf(localTime.plusHours(2)), new Station("3", "Station 3", 20));

        // Dequeue train arrivals based on priority
        System.out.println("\n------Train Arrivals------");
        while (!arrivalPriorityQueue.isEmpty()) {
            TrainArrival trainArrival = trainJourney.dequeueTrainArrival();
            System.out.println("Train Name: " + trainArrival.getTrainName());
            System.out.println("Arrival Time: " + trainArrival.getTime());
            System.out.println("Current Station: " + trainArrival.getCurrentStation().getName());
            System.out.println();
        }

        Graph stationConnections = new Graph();
        stationConnections.addConnection(shortestPath);
        stationConnections.traverseAndDisplay(shortestPath);

        BoardingQueue boardingQueue = new BoardingQueue();

        StatisticsCollector statisticsCollector = new StatisticsCollector();

        for (Station station : trainJourney.findShortestPath(startStation, endStation)) {
            // Simulating passenger boarding and updating statistics at each station
            String currentStation = station.getName();

            statisticsCollector.updateStatistics(boardingQueue, currentStation);
            boardingQueue.equals(0);
            for (int i = 1; i <= Constants.PASSENGERS; i++) {
                boardingQueue.enqueuePassenger(new Passenger("Passenger 0" + i));
            }
        }
        // Display final statistics
        statisticsCollector.displayStatistics();


        System.out.println("Train Arrival Queue");

        Stack stack = new Stack();
        pq = trainQueue.push(pq, "Express", 200);
        pq = trainQueue.push(pq, "Local", 78);
        pq = trainQueue.push(pq, "Ruhunu", 890);
        pq = trainQueue.push(pq, "New", 87);

        while (trainQueue.isEmpty(pq) == 0) {
            String trainName = trainQueue.peek(pq);
            if (trainName != null) {
                stack.push(trainName);
            }
            pq = trainQueue.pop(pq);
        }

        while (!stack.isEmpty()) {
            System.out.println(" " + stack.pop());
        }
    }

    private static void printMatrix(double[][] matrix, List<Integer> station) {

        //Print headers
        System.out.printf("%-14s", "");  // Empty space for row labels
        for (int stations : station) {
            System.out.printf("Station %-8s", stations);
        }
        System.out.println();

        //Print rows
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("Station %-8s", station.get(i));
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%-15.1f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}