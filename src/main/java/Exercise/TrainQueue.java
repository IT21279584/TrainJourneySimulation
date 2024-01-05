package Exercise;

import java.util.Stack;

public class TrainQueue {
    public static Train newNode(String trainName, int priority){

        Train temp = new Train();
        temp.trainName = trainName;
        temp.priority = priority;
        temp.next = null;

        return temp;
    }

    //Return the value of head
    public static String peek(Train head){
        return head.trainName;
    }

    public static Train pop(Train head){
        Train temp = head;
        head = head.next;
        return head;
    }

    public static Train push(Train head, String trainName, int priority){
        Train start = head;
        Train temp = newNode(trainName, priority);

        if(head.priority > priority){
            temp.next = head;
            head = temp;
        }else{
            while(start.next != null && start.next.priority < priority){
                start = start.next;
            }
            temp.next = start.next;
            start.next = temp;
        }
        return head;
    }

    public static int  isEmpty(Train head){
        return  (head == null)?1:0;
    }
}