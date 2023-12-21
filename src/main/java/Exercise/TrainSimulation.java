package Exercise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainSimulation {
//    static Logger logger = LoggerFactory.getLogger(TrainSimulation.class);
    public static void main(String[] args){
        double adjMatrix[][] = {
                {0, 10, 0, 10, 0},
                {10, 0, 15, 10, 0},
                {0, 15, 0, 25, 0},
                {10, 10, 25, 0, 0},
                {0, 0, 0, 0, 0}
        };

        Track track = new Track();
        TrackJourney path = new TrackJourney(adjMatrix);

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

        Station startStation = new Station(startStationSid, "Station " + startStationSid, 0);
        Station endStation = new Station(endStationSid, "Station " + endStationSid, 0);

        // Validate input
        if (Integer.parseInt(startStationSid) >= 1 && Integer.parseInt(endStationSid) <= adjMatrix.length) {
            List<Station> shortestPath = path.findShortestPath(startStation, endStation);

            System.out.println("Shortest path from " + startStation.getName() + " to " + endStation.getName() + ":");
            System.out.println("\nIntermediate stations:");

            for (Station station : shortestPath) {
                System.out.println(station.getName());
            }

        } else {
            System.out.println("Invalid input. Please enter valid station indices.");
        }

        scanner.close();

//        if(startIndex != -1 && endIndex != -1 && startIndex <= endIndex){
//            for(int i = startIndex; i <= endIndex; i++){
//                System.out.println(stations.get(i));
//            }
//        }else if(startIndex != -1 && endIndex != -1 && endIndex <= startIndex){
//            for(int i = startIndex; i >= endIndex; i--){
//                System.out.println(stations.get(i));
//            }
//        }else{
//            logger.error("Invalid Station. Please enter the valid station");
//        }
    }
}