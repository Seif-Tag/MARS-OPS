import java.util.ArrayList;

public class MISSION {
    private String type;
    private String requiredSkill;
    private String requiredEquipment;
    private String requiredResource;
    private int requiredQuantity;
    private ArrayList<MISSON_CAPABLE> assignedAgents;
    private String status;
    private String failureReason;

    public MISSION(String type, String requiredSkill,String requiredEquipment, String requiredResource,int requiredQuantity) {
        this.type = type;
        this.requiredSkill = requiredSkill;
        this.requiredEquipment = requiredEquipment;
        this.requiredResource = requiredResource;
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

    public void fail(String reason) {
        status = "FAILED";
        failureReason = reason;
    }
}