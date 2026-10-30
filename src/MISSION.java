import java.util.ArrayList;

public class MISSION {
    private String type;
    private String requiredSkill;
    private String requiredEquipment;
    private String requiredResource;
    private int requiredQuantity;
    private int duration;
    private int  elapsed_time;     
    private ArrayList<MISSON_CAPABLE> assignedAgents;
    private String status;
    private String failureReason;

    public MISSION(String type, String requiredSkill,String requiredEquipment, String requiredResource,int requiredQuantity,int duration,int  elapsed_time) {
        this.type = type;
        this.requiredSkill = requiredSkill;
        this.requiredEquipment = requiredEquipment;
        this.requiredResource = requiredResource;
        this.duration=duration;
        this.elapsed_time=elapsed_time;
        this.requiredQuantity = requiredQuantity;
        this.assignedAgents = new ArrayList<>();
        this.status = "SUBMITTED";
        this.failureReason = "";
    }

    public String getType() {
        return type;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public String getRequiredEquipment() {
        return requiredEquipment;
    }

    public String getRequiredResource() {
        return requiredResource;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getElapsed_time() {
        return elapsed_time;
    }

    public void setElapsed_time(int elapsed_time) {
        this.elapsed_time = elapsed_time;
    }

    public String getStatus() {
        return status;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public ArrayList<MISSON_CAPABLE> getAssignedAgents() {
        return assignedAgents;
    }

    public void addAgent(MISSON_CAPABLE agent) {
        assignedAgents.add(agent);
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public boolean isrobot() {
     return true ;      
    }

    public void fail(String reason) {
        status = "FAILED";
        failureReason = reason;
    }
        public boolean enviroment_mission(Enviroment env )
    {
        if(type.equalsIgnoreCase("Exploration") && env==Enviroment.Dust_storms)
        {
            return true;
        }
        if(type.equalsIgnoreCase("rescue") && env==Enviroment.Comm_disruption)
        {
            return true;
        }
        return false;
    }
    public void advanceTime(){
        if(status.equalsIgnoreCase("IN_PROGRESS")){
            elapsed_time++;
            if(elapsed_time>= duration){
                status= "COMPLETED";
            }
        }
        
    }
    
}