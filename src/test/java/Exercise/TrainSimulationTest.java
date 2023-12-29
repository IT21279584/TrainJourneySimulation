package Exercise;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TrainSimulationTest {

    @Test
    void main() {
        String Inputs = "2\n5\n";

        // Simulate user Inputs
        InputStream inputStream = System.in;
        // capture the system output
        PrintStream printStream = System.out;

        System.setIn(new ByteArrayInputStream(Inputs.getBytes()));
        ByteArrayOutputStream outContent  = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TrainSimulation.main(null);

        System.setOut(System.out);

        String expectOutput = "------Available stations------\n" +
                "Station 1\n" +
                "Station 2\n" +
                "Station 3\n" +
                "Station 4\n" +
                "Station 5\n" +
                "Enter start station: \n" +
                "Enter end station: \n" +
                "Shortest path from Station 2 to Station 5:\n" +
                "\n" +
                "-------Path stations--------\n" +
                "Station 2\n" +
                "Station 1\n" +
                "Station 4\n" +
                "Station 5\n" +
                "\n" +
                "------Train Schedules------\n" +
                "Train is : Express Train\n" +
                "Schedules \n" +
                "Station 1\n" +
                "Station 2\n" +
                "Station 3\n" +
                "Train is : Local Train\n" +
                "Schedules \n" +
                "Station 1\n" +
                "Station 2\n" +
                "Train is : Local Train\n" +
                "Schedules \n" +
                "Station 5\n" +
                "Station 6\n" +
                "\n" +
                "------Train Arrivals------\n" +
                "Train Name: Express Train\n" +
                "Current Station: Station 2\n" +
                "\n" +
                "Train Name: Local Train\n" +
                "Current Station: Station 3\n" +
                "\n" +
                "Visited Station: Station 2\n" +
                "Visited Station: Station 5\n" +
                "\n" +
                "\n" +
                "------ Simulation Statistics ------\n" +
                "Stations Visited: 1\n" +
                "Total Boarded Passengers: 0\n" +
                "Average Boarding Time: N/A (No passengers boarded)\n" +
                "Passengers at Each Station: {Station 2=0}\n" +
                "-----------------------------------\n" +
                "Passenger 01 has joined the boarding queue\n" +
                "Passenger 02 has joined the boarding queue\n" +
                "Passenger 03 has joined the boarding queue\n" +
                "\n" +
                "------ Simulation Statistics ------\n" +
                "Stations Visited: 2\n" +
                "Total Boarded Passengers: 3\n" +
                "Average Boarding Time: 2\n" +
                "Passengers at Each Station: {Station 2=0, Station 1=3}\n" +
                "-----------------------------------\n" +
                "Passenger 01 has joined the boarding queue\n" +
                "Passenger 02 has joined the boarding queue\n" +
                "Passenger 03 has joined the boarding queue\n" +
                "\n" +
                "------ Simulation Statistics ------\n" +
                "Stations Visited: 3\n" +
                "Total Boarded Passengers: 9\n" +
                "Average Boarding Time: 2\n" +
                "Passengers at Each Station: {Station 2=0, Station 1=3, Station 4=6}\n" +
                "-----------------------------------\n" +
                "Passenger 01 has joined the boarding queue\n" +
                "Passenger 02 has joined the boarding queue\n" +
                "Passenger 03 has joined the boarding queue\n" +
                "\n" +
                "------ Simulation Statistics ------\n" +
                "Stations Visited: 4\n" +
                "Total Boarded Passengers: 18\n" +
                "Average Boarding Time: 2\n" +
                "Passengers at Each Station: {Station 2=0, Station 1=3, Station 4=6, Station 5=9}\n" +
                "-----------------------------------\n" +
                "Passenger 01 has joined the boarding queue\n" +
                "Passenger 02 has joined the boarding queue\n" +
                "Passenger 03 has joined the boarding queue\n" +
                "\n" +
                "------ Simulation Statistics ------\n" +
                "Stations Visited: 4\n" +
                "Total Boarded Passengers: 18\n" +
                "Average Boarding Time: 2\n" +
                "Passengers at Each Station: {Station 2=0, Station 1=3, Station 4=6, Station 5=9}\n" +
                "-----------------------------------\n";
        assertEquals(expectOutput, outContent.toString());
    }
}