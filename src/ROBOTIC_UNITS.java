public class ROBOTIC_UNITS implements MISSON_CAPABLE{
    protected int battery_level;
    protected String HEALTH_DAMAGE_STAT;
    protected String CURRENT_LOC;
    protected String Availabity;

    public ROBOTIC_UNITS(int battery_level, String HEALTH_DAMAGE_STAT, String CURRENT_LOC, String Availabity) {
        this.battery_level = battery_level;
        this.HEALTH_DAMAGE_STAT = HEALTH_DAMAGE_STAT;
        this.CURRENT_LOC = CURRENT_LOC;
        this.Availabity = Availabity;
    }

    public int getBattery_level() {
        return battery_level;
    }

    public void setBattery_level(int battery_level) {
        this.battery_level = battery_level;
    }

    public String getHEALTH_DAMAGE_STAT() {
        return HEALTH_DAMAGE_STAT;
    }

    public void setHEALTH_DAMAGE_STAT(String HEALTH_DAMAGE_STAT) {
        this.HEALTH_DAMAGE_STAT = HEALTH_DAMAGE_STAT;
    }

    public String getCURRENT_LOC() {
        return CURRENT_LOC;
    }

    public void setCURRENT_LOC(String CURRENT_LOC) {
        this.CURRENT_LOC = CURRENT_LOC;
    }

    @Override
    public boolean isAvailable() {
    return Availabity.equalsIgnoreCase("Available");
}

    @Override
   public void setAvailability(String status) {
    Availabity = status;
}
    @Override
    public boolean canPerform(MISSION mission) {
        return false;
    }

    @Override
    public String get_location() {
        return CURRENT_LOC;
    }

    @Override
    public void set_location(String location) {
        this.CURRENT_LOC=location;
    }
    @Override
  public boolean canHandle(String emergencyType) {
    return false;
    }
    public boolean isUsable() {
        return HEALTH_DAMAGE_STAT.equalsIgnoreCase("Healthy") && battery_level > 0;
    }
    public boolean isrobot()
    {
        return true;
    }
    
    public void set_health(String health) {
    setHEALTH_DAMAGE_STAT(health);
    }

    public String getAvailabity() {
        return Availabity;
    }

    public void setAvailabity(String Availabity) {
        this.Availabity = Availabity;
    }
    public void worksbytime()
    {
        battery_level-=10;
        if(battery_level<=0)
            battery_level=0;  
    }

    
    
}
