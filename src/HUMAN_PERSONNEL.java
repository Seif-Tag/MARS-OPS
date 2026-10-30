public class HUMAN_PERSONNEL implements MISSON_CAPABLE {
    protected String Name;
    protected int ID_NO;
    protected String Health_Stat;
    protected String Current_STAT;
    protected String skill;
    protected int FATIGUE_LEVEL;
    protected String AVAILABILITY;

    public HUMAN_PERSONNEL(String Name, int ID_NO, String Health_Stat, String Current_STAT, String skill, int FATIGUE_LEVEL, String AVAILABILITY) {
        this.Name = Name;
        this.ID_NO = ID_NO;
        this.Health_Stat = Health_Stat;
        this.Current_STAT = Current_STAT;
        this.skill = skill;
        this.FATIGUE_LEVEL = FATIGUE_LEVEL;
        this.AVAILABILITY = AVAILABILITY;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getID_NO() {
        return ID_NO;
    }

    public void setID_NO(int ID_NO) {
        this.ID_NO = ID_NO;
    }

    public String getHealth_Stat() {
        return Health_Stat;
    }

    public void setHealth_Stat(String Health_Stat) {
        this.Health_Stat = Health_Stat;
    }

    public String getCurrent_STAT() {
        return Current_STAT;
    }

    public void setCurrent_STAT(String Current_STAT) {
        this.Current_STAT = Current_STAT;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getFATIGUE_LEVEL() {
        return FATIGUE_LEVEL;
    }

    public void setFATIGUE_LEVEL(int FATIGUE_LEVEL) {
        this.FATIGUE_LEVEL = FATIGUE_LEVEL;
    }

   @Override
    public boolean isAvailable() {
    return AVAILABILITY.equalsIgnoreCase("Available");
}

    @Override
    public void setAvailability(String status) {
    AVAILABILITY = status;
}

    @Override
    public boolean canPerform(MISSION mission) {
        return false;
    }

    @Override
    public String get_location() {
        return Current_STAT;
    }

    @Override
    public void set_location(String location) {
        this.Current_STAT=location;
    }
    @Override
    public boolean canHandle(String emergencyType) {
    return false;
    }
    @Override
    public boolean isUsable() {
        return Health_Stat.equalsIgnoreCase("Healthy");
    }
    @Override
    public boolean isrobot() {
        return false;
    }
    @Override
    public void set_health(String health) 
    {
       setHealth_Stat(health);

    }
    public void worksbytime()
    {
        FATIGUE_LEVEL+=1;
    }

  }
