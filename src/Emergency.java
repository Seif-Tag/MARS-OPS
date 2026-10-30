import java.util.ArrayList;
public abstract class Emergency {
    private String location;
    private ArrayList<MISSON_CAPABLE> assignedAgents;
    private String status;
    private String failureReason;

    public Emergency(String location) {
        this.location = location;
        this.assignedAgents = new ArrayList<>();
        this.status = "pending";
        this.failureReason=" ";
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<MISSON_CAPABLE> getAssignedAgents() {
        return assignedAgents;
    }

    public void setAssignedAgents(ArrayList<MISSON_CAPABLE> assignedAgents) {
        this.assignedAgents = assignedAgents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
   
    public void dispatch(MISSON_CAPABLE agent)
    {
        
        agent.set_location(location);
        
    }
    public abstract void handle(COLONY_MANAGMENT colony);
    protected abstract int humansNeeded();
    protected abstract int robotsNeeded();
    protected MISSON_CAPABLE findResponder(COLONY_MANAGMENT COLONY, String type,boolean robot) {
    for (MISSON_CAPABLE agent :COLONY.getAgents() ) {
        if (agent.canHandle(type)                 
                && agent.isAvailable()             
                && agent.isUsable()   
                && agent.isrobot()== robot
                && !assignedAgents.contains(agent)) {  
            return agent;
        }
    }
    return null;
}
    public void responders_unavailable(String reason ){
        status="unresolved";
        failureReason=reason;
        assignedAgents.clear();
        System.out.println("the Emergency at"+location+"is unresolved because of "+reason);
        
    }
    public boolean getresponders(COLONY_MANAGMENT colony,String type)
    { 
        for (int i=0;i<humansNeeded();i++)
        {
           MISSON_CAPABLE found=findResponder(colony,type,false);
           if(found==null)
           {responders_unavailable("no humans available for this emergency"+type);
           return false;
           }
           assignedAgents.add(found);

        }
        for (int i=0;i<robotsNeeded();i++)
        {
             MISSON_CAPABLE found=findResponder(colony,type,true);
           if(found==null)
           {responders_unavailable("no robots available for this emergency"+type);
           return false;
           }
           assignedAgents.add(found);
        
        }
        for (MISSON_CAPABLE agent : assignedAgents) {
        dispatch(agent);    
    }
    return true;
  }
    
}
