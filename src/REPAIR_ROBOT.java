public class REPAIR_ROBOT extends ROBOTIC_UNITS{
    private String CAPABILITIES;
    private String spare_parts;

    public REPAIR_ROBOT(int battery_level, String HEALTH_DAMAGE_STAT, String CURRENT_LOC, String Availabity,String spare_parts) {
        super(battery_level, HEALTH_DAMAGE_STAT, CURRENT_LOC, Availabity);
        this.CAPABILITIES = "Repairs damaged equipment and operates inside facilities.";
        this.spare_parts=spare_parts;
    }

    public String getCAPABILITIES() {
        return CAPABILITIES;
    }
    @Override
    public boolean canPerform(MISSION mission) {
      if(mission.getType().equalsIgnoreCase("repair")
              && Availabity.equalsIgnoreCase("Available")  
              && HEALTH_DAMAGE_STAT.equalsIgnoreCase("Healthy") 
              && battery_level >0 
              && spare_parts.equalsIgnoreCase(mission.getRequiredEquipment())){
            return true;
        }
        return false;
    }
    @Override
public boolean canHandle(String type) {
    return type.equalsIgnoreCase("OXYGEN_LEAK") || type.equalsIgnoreCase("fire");
}
    
}
