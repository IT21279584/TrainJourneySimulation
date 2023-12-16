package Exercise;

public class Track {

    private static class Node{
        Station station;
        Node next;
        Node previous;

        public Node(Station station){
            this.station = station;
        }
    }

    Node head = null;
    Node tail = null;

    public void displayStations(){

        Node current = head;
        while (current != null){
            System.out.println("Station Name" + current.station.getName());
            System.out.println("Station ID" + current.station.getName());
            System.out.println("Station Distance" + current.station.getDistanceFromStation());
            System.out.println();

            current = current.next;
        }


    }
}
