import java.util.ArrayList;

public class COLONY_MANAGMENT {

    protected ArrayList<FACILITIES> facility;
    protected ArrayList<MISSON_CAPABLE> agents;
    private MISSION activeMission;

    public COLONY_MANAGMENT() {
        facility = new ArrayList<>();
        agents = new ArrayList<>();
        activeMission = null;
    }

    public void addFacility(FACILITIES item) {
        facility.add(item);
    }

    public void addAgent(MISSON_CAPABLE agent) {
        agents.add(agent);
    }

    public int getTotalResource(String name) {
        int total = 0;

        for (FACILITIES item : facility) {
            if (item.isOP_STAT()) {
                for (RESOURCES resource : item.resources) {
                    if (resource.getResourceName().equalsIgnoreCase(name)) {
                        total += resource.getResourceQuanitiy();
                    }
                }
            }
        }

        return total;
    }

    public boolean ReqResource(String name, int amount) {
        if (amount <= 0 || getTotalResource(name) < amount) {
            return false;
        }

        int remaining = amount;

        for (FACILITIES item : facility) {
            if (item.isOP_STAT()) {
                for (RESOURCES resource : item.resources) {
                    if (resource.getResourceName().equalsIgnoreCase(name)) {
                        int quantity = resource.getResourceQuanitiy();
                        int used = Math.min(quantity, remaining);

                        resource.setResourceQuantity(quantity - used);
                        remaining -= used;

                        if (remaining == 0) {
                            return true;
                        }
                    }
                }
            }
        }

        return remaining == 0;
    }

    private boolean isAvailable(MISSON_CAPABLE agent) {
        return agent.isAvailable();
    }

    private void setAgentAvailability(MISSON_CAPABLE agent, String status) {
        agent.setAvailability(status);
    }

    public boolean submitMission(MISSION mission, ArrayList<MISSON_CAPABLE> requiredAgents) {

        if (mission == null) {
            return false;
        }

        if (!mission.getStatus().equalsIgnoreCase("SUBMITTED")) {
            mission.fail("This mission has already been processed.");
            return false;
        }

        if (activeMission != null) {
            mission.fail("Another mission is already active.");
            return false;
        }

        if (requiredAgents == null || requiredAgents.isEmpty()) {
            mission.fail("No agents were assigned to the mission.");
            return false;
        }

        for (int i = 0; i < requiredAgents.size(); i++) {
            MISSON_CAPABLE agent = requiredAgents.get(i);

            if (agent == null || !agents.contains(agent)) {
                mission.fail("Agent is not registered with the colony.");
                return false;
            }

            if (requiredAgents.indexOf(agent) != i) {
                mission.fail("The same agent cannot be assigned twice.");
                return false;
            }

            if (!isAvailable(agent)) {
                mission.fail("An assigned agent is not available.");
                return false;
            }

            if (!agent.canPerform(mission)) {
                mission.fail("An assigned agent cannot perform this mission.");
                return false;
            }
        }

        if (mission.getRequiredQuantity() < 0) {
            mission.fail("Resource quantity cannot be negative.");
            return false;
        }

        if (mission.getRequiredQuantity() > 0) {
            String resourceName = mission.getRequiredResource();

            if (resourceName == null || resourceName.trim().isEmpty()) {
                mission.fail("Required resource was not specified.");
                return false;
            }

            if (getTotalResource(resourceName) < mission.getRequiredQuantity()) {
                mission.fail("Insufficient colony resources.");
                return false;
            }

            if (!ReqResource(resourceName, mission.getRequiredQuantity())) {
                mission.fail("Resource consumption failed.");
                return false;
            }
        }

        mission.getAssignedAgents().clear();

        for (MISSON_CAPABLE agent : requiredAgents) {
            mission.addAgent(agent);
            setAgentAvailability(agent, "Busy");
        }

        mission.setStatus("ASSIGNED");
        activeMission = mission;

        return true;
    }

    public void startActiveMission() {
        if (activeMission != null
                && activeMission.getStatus().equalsIgnoreCase("ASSIGNED")) {
            activeMission.setStatus("IN_PROGRESS");
        }
    }

    public void finishActiveMission(boolean completed, String reason) {
        if (activeMission == null) {
            return;
        }

        if (completed) {
            activeMission.setStatus("COMPLETED");
        } else {
            activeMission.fail(reason);
        }

        for (MISSON_CAPABLE agent : activeMission.getAssignedAgents()) {
            setAgentAvailability(agent, "Available");
        }

        activeMission = null;
    }

    public MISSION getActiveMission() {
        return activeMission;
    }

    public void LocalEmergency(String type, int leak, FACILITIES item) {
        if (item == null || leak <= 0) {
            return;
        }

        RESOURCES resource = item.getResource(type);

        if (resource != null) {
            int quantity = resource.getResourceQuanitiy();
            int lost = Math.min(quantity, leak);

            resource.setResourceQuantity(quantity - lost);
        }
    }

    public void COLONY_REPORT() {
        System.out.println("Total oxygen is " + getTotalResource("oxygen"));
        System.out.println("Total water is " + getTotalResource("water"));
        System.out.println("Total fuel is " + getTotalResource("fuel"));
        System.out.println("Total food is " + getTotalResource("food"));
        System.out.println("Total medical supplies is "
                + getTotalResource("medical supplies"));
        System.out.println("Total battery power is "
                + getTotalResource("battery power"));
        System.out.println("Total spare parts is "
                + getTotalResource("spare parts"));
    }
}
public void advanceMissionTime() {
    if (activeMission == null) {
        System.out.println("No active mission.");
        return;
    }

    if (!activeMission.getStatus().equals("IN_PROGRESS")) {
        System.out.println("Mission is not in progress.");
        return;
    }

    activeMission.advanceTime();

    System.out.println("Mission time: "  + activeMission.getElapsed_time() + "/"+ activeMission.getDuration());

    if (activeMission.getStatus().equals("COMPLETED")) {
        finishActiveMission(true, "");
        System.out.println("Mission completed successfully.");
    }
}
}