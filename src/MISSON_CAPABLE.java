public interface MISSON_CAPABLE {
    boolean canPerform(MISSION mission);
    boolean isAvailable();
    String get_location();
    void setAvailability(String status);
    void set_location(String location);
    void set_health(String health);
    void worksbytime();
    boolean canHandle(String emergency_type);
    boolean isUsable();
    boolean isrobot();
}