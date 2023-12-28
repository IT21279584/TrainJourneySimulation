package Exercise;

import javax.swing.plaf.synth.SynthLookAndFeel;

public class Track {

    Node head = null;
    Node tail = null;

    public static class Node{
        Station station;
        Node next;
        Node previous;

        public Node(Station station){
            this.station = station;
        }
    }



    public void displayStations(){

        Node current = head;
       // System.out.println("Hello, Working"+current);
        while (current != null){
            System.out.println("Station Name" + current.station.getName());
            System.out.println("Station ID" + current.station.getName());
            System.out.println("Station Distance" + current.station.getDistanceFromStation());
            System.out.println();

            current = current.next;
           // System.out.println("Hello, Working"+ current);
        }
    }
}
