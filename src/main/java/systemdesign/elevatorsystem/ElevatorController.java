package systemdesign.elevatorsystem;

// Manage elevator operations and scheduling

import java.util.List;

// Manages the operation and co-ordination of all elevators in a building
public class ElevatorController {

    // List of all elevators controlled by this system
    private List<Elevator> elevators;

    // List of floors in the buildings
    private List<Floor> floors;

    // Strategy to decide which elevator should handle a request.
    // private SchedulingStrategy schedulingStrategy;

    // Keeps track of the current elevator's ID for handling internal requests
    private int currentElevatorId;




}
