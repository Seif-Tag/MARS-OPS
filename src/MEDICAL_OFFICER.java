public class MEDICAL_OFFICER extends HUMAN_PERSONNEL{
    private String responsibilty;
    private String availble_Personnel;

    public MEDICAL_OFFICER(String Name, int ID_NO, String Health_Stat, String Current_STAT, String skill, int FATIGUE_LEVEL, String AVAILABILITY,String availble_Personnel) {
        super(Name, ID_NO, Health_Stat, Current_STAT, skill, FATIGUE_LEVEL, AVAILABILITY);
        this.responsibilty = "Responds to medical emergencies.";
        this.availble_Personnel= availble_Personnel;
    }

    public String getResponsibilty() {
        return responsibilty;
    }

    @Override
    public boolean canPerform(MISSION mission) {
        if(mission.getType().equalsIgnoreCase("rescue")
                && FATIGUE_LEVEL != 0
                && AVAILABILITY == "TRUE"
                && skill.equalsIgnoreCase(mission.getRequiredSkill())
                && availble_Personnel.equalsIgnoreCase(mission.getRequiredEquipment())){
            return true;
        }
        return false;
    }
    @Override
public boolean canHandle(String type) {
    return type.equalsIgnoreCase("MEDICAL");
}
    
}
