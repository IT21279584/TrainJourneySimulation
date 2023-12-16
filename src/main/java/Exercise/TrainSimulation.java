package Exercise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.TransformerConfigurationException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainSimulation {
    static Logger logger = LoggerFactory.getLogger(TrainSimulation.class);
    public static void main(String[] args){

        Track track = new Track();
        ArrayList<String> stations = new ArrayList<>();
        stations.add("Station A");
        stations.add("Station B");
        stations.add("Station C");
        stations.add("Station D");
        stations.add("Station E");

        System.out.println("------Available stations------");
        for (String station : stations) {
            System.out.println(station);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start station : ");
        String start = sc.nextLine();
        System.out.println("Enter end station : ");
        String end = sc.nextLine();

        int startIndex = stations.indexOf(start);
        int endIndex = stations.indexOf(end);

        if(startIndex != -1 && endIndex != -1 && startIndex <= endIndex){
            for(int i = startIndex; i <= endIndex; i++){
                System.out.println(stations.get(i));
            }
        }else if(startIndex != -1 && endIndex != -1 && endIndex <= startIndex){
            for(int i = startIndex; i >= endIndex; i--){
                System.out.println(stations.get(i));
            }
        }else{
            logger.error("Invalid Station. Please enter the valid station");
        }
    }
}