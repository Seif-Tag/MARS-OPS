public class EXPLORATION_ROVER extends ROBOTIC_UNITS{
    private String CAPABILITIES;
    private String equipment;

    public EXPLORATION_ROVER(int battery_level, String HEALTH_DAMAGE_STAT, String CURRENT_LOC, String Availabity, String equipment) {
        super(battery_level, HEALTH_DAMAGE_STAT, CURRENT_LOC, Availabity);
        this.CAPABILITIES = "Travels across the Martian surface, carries equipment, and perfoms exploration.";
        this.equipment= equipment;
    }

    public String getCAPABILITIES() {
        return CAPABILITIES;
    }

    @Override
    public boolean canPerform(MISSION mission) {
      if(mission.getType().equalsIgnoreCase("exploration")
              && Availabity.equalsIgnoreCase("Available")  
              && HEALTH_DAMAGE_STAT.equalsIgnoreCase("Healthy")
              && battery_level >0 
              && equipment.equalsIgnoreCase(mission.getRequiredEquipment())){
            return true;
        }
        return false;
    }
    
    
}
