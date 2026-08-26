package systemdesign.elevatorsystem;

import javax.annotation.Priority;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Elevator {
    // Unique identifier for the elevator
    private int id;

    // The floor where the elevator is currently located
    private int currentFloor;

    // The current operational state of the elevator (e.g...MOVING, IDLE etc., )
    private Direction direction;

    // A list of observers (listeners) that monitor the elevator's status
    // private List<ElevatorObserver> observers;

    // A simple queue to manage floor requests in the order they are received.
    //private PriorityQueue<ElevatorRequest> requestsQueue;

    //private List<ElevatorRequest> destinationFloors;

    // Get the elevator's id
    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    // Get the elevator's current state
    public Direction getDirection() {
        return direction;
    }

    // public List<ElevatorObserver> getObservers() {
    //     return observers;
    //   }

    // Get the copy of the current requests to prevent external modification
    // public PriorityQueue<ElevatorRequest> getRequestsQueue() {
    //    return requestsQueue;
    //  }

    // Get the list of all destination floors for display purposes
    // public List<ElevatorRequest> getDestinationFloors() {
    //    return new ArrayList<>(requestsQueue);
    // }

    }



