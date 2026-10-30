import java.util.ArrayList;

public   class rover_breakdown extends Emergency{
    private EXPLORATION_ROVER rover ;
    private int spare_parts;

    public rover_breakdown(EXPLORATION_ROVER rover, int spare_parts, String location) {
        super(rover.get_location());
        this.rover = rover;
        this.spare_parts = spare_parts;
    }

    public int robotsNeeded()
    {
        return 0;
    }
    public int humansNeeded()
    {
        return 0;
        
    }
    @Override
    public void handle(COLONY_MANAGMENT colony) {
       rover.setHEALTH_DAMAGE_STAT("damaged");
        System.out.println("the rover is damaged and remains at this location"+rover.get_location());
        if(colony.getActiveMission()!=null
        && colony.getActiveMission().getAssignedAgents().contains(rover)) {
    colony.finishActiveMission(false, "Rover broke down at " + getLocation());
    
                colony.finishActiveMission(false, "the rover in the mission is brokedown");
       }
    System.out.println("Repair requires " + spare_parts + " spare parts. A repair mission can now be created.");
setStatus("RESOLVED");
    
    
    }
    
    }

    
    
     

    
    
    

