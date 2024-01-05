package Exercise;

import java.util.*;

public class Graph {
    private Map<Station, List<Station>> stationConnection;

    public Graph(){
        this.stationConnection = new HashMap<>();
    }

    public void addConnection(List<Station> connectStations){
        Station.setConnectStation(connectStations);
    }


    public void traverseAndDisplay(List<Station> start) {
        Set<Station> visited = new HashSet<>();
        Queue<Station> queue = new LinkedList<>();

        queue.addAll(start);
        visited.addAll(start);

        while (!queue.isEmpty()) {
            Station current = queue.poll();
            System.out.println("Visited Station: " + current.getName());

            for (Station connectedStation : current.getConnectStation()) {
                if (!visited.contains(connectedStation)) {
                    queue.add(connectedStation);
                    visited.add(connectedStation);
                }
            }
        }

        System.out.println();
    }

}