/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class ENGINEER extends HUMAN_PERSONNEL {
    private String responsibilty;
    private String spare_parts;

    public ENGINEER(String Name, int ID_NO, String Health_Stat, String Current_STAT, String skill, int FATIGUE_LEVEL, String AVAILABILITY, String spare_parts) {
        super(Name, ID_NO, Health_Stat, Current_STAT, skill, FATIGUE_LEVEL, AVAILABILITY);
        this.responsibilty = "Repairs damaged equiment";
        this.spare_parts=  spare_parts;
    }

    public String getResponsibilty() {
        return responsibilty;
    }

    @Override
    public boolean canPerform(MISSION mission) {
         if(mission.getType().equalsIgnoreCase("repair")
                 && skill.equalsIgnoreCase(mission.getRequiredSkill())
                 && FATIGUE_LEVEL != 0
                 && AVAILABILITY == "TRUE"
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
