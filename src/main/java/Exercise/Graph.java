package Exercise;

import java.util.*;

public class Graph {
    private Map<Station, List<Station>> stationConnection;

    public Graph(){
        this.stationConnection = new HashMap<>();
    }

    public void addConnection(Station source, Station destination){
        source.setConnectStation(destination);
        destination.setConnectStation(source);
    }

    public void traverseAndDisplay(Station start) {
        Set<Station> visited = new HashSet<>();
        Queue<Station> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

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