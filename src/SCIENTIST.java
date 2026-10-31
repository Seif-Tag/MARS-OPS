public class SCIENTIST extends HUMAN_PERSONNEL {
    private String responsibility;
    private String equipment;

    public SCIENTIST( String Name, int ID_NO, String Health_Stat, String Current_STAT, String skill, int FATIGUE_LEVEL, String AVAILABILITY,String equipment) {
        super(Name, ID_NO, Health_Stat, Current_STAT, skill, FATIGUE_LEVEL, AVAILABILITY);
        this.responsibility = "Perfoms scientific research";
        this.equipment= equipment;
    }

    public String getResponsibility() {
        return responsibility;
    }

   @Override
public boolean canPerform(MISSION mission) {
    if ((mission.getType().equalsIgnoreCase("research") ||
         mission.getType().equalsIgnoreCase("exploration"))
            && skill.equalsIgnoreCase(mission.getRequiredSkill())
            && equipment.equalsIgnoreCase(mission.getRequiredEquipment())
            && FATIGUE_LEVEL != 0
            && AVAILABILITY.equalsIgnoreCase("TRUE")) {
        return true;
    }
    return false;
}
    }

   
    
    

