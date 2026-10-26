public interface MISSON_CAPABLE {
    boolean canPerform(MISSION mission);
    boolean isAvailable();
    void setAvailability(String status);
}