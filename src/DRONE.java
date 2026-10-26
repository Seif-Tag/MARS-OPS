public class DRONE extends ROBOTIC_UNITS{
    private String CAPABILITIES;
    private String availble_Personnel;

    public DRONE(int battery_level, String HEALTH_DAMAGE_STAT, String CURRENT_LOC, String Availabity,String availble_Personnel) {
        super(battery_level, HEALTH_DAMAGE_STAT, CURRENT_LOC, Availabity);
        this.CAPABILITIES = "Performs aerial reconnaissance and operates in areas inaccessible to ground vehicles.";
        this.availble_Personnel= availble_Personnel;
    }

    public String getCAPABILITIES() {
        return CAPABILITIES;
    }
    @Override
    public boolean canPerform(MISSION mission) {
      if(mission.getType().equalsIgnoreCase("rescue")
              && Availabity.equalsIgnoreCase("Available")  
              && HEALTH_DAMAGE_STAT.equalsIgnoreCase("Healthy") 
              && battery_level >0 
              && CAPABILITIES.equalsIgnoreCase(mission.getRequiredEquipment())
              && availble_Personnel.equalsIgnoreCase(mission.getRequiredSkill())){
            return true;
        }
        return false;
    }
    
}
