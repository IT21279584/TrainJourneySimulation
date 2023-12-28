package Exercise;

import java.util.HashMap;
import java.util.Map;

public class StatisticsCollector {

    private Map<String, Integer> passengersAtStation;
    private int totalBoardedPassengers;
    private int totalBoardingTime;
    private int stationsVisited;

    public StatisticsCollector() {
        this.passengersAtStation = new HashMap<>();
        this.totalBoardedPassengers = 0;
        this.totalBoardingTime = 0;
        this.stationsVisited = 0;
    }

    public void updateStatistics(BoardingQueue boardingQueue, String currentStation) {
        // Update the number of passengers at the current station
        int passengersAtCurrentStation = boardingQueue.passengerQueue.size();
        passengersAtStation.put(currentStation, passengersAtCurrentStation);

        // Update total boarded passengers
        totalBoardedPassengers += passengersAtCurrentStation;

        // Update total boarding time (assuming a fixed boarding time for simplicity)
        totalBoardingTime += passengersAtCurrentStation * 2; // 2 units of time per passenger

        // Increment stations visited
        stationsVisited++;

        // Display current statistics
        displayStatistics();
    }

    public void displayStatistics() {
        System.out.println("\n------ Simulation Statistics ------");
        System.out.println("Stations Visited: " + stationsVisited);
        System.out.println("Total Boarded Passengers: " + totalBoardedPassengers);

        if (totalBoardedPassengers != 0) {
            System.out.println("Average Boarding Time: " + (totalBoardingTime / totalBoardedPassengers));
        } else {
            System.out.println("Average Boarding Time: N/A (No passengers boarded)");
        }

        System.out.println("Passengers at Each Station: " + passengersAtStation);
        System.out.println("-----------------------------------");
    }
}
