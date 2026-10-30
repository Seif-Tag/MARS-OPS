
public class simulation_time {
    private COLONY_MANAGMENT colony;
    private int advancetime;

    public simulation_time(COLONY_MANAGMENT colony) {
        this.colony = colony;
        this.advancetime = 0;
    }

    public COLONY_MANAGMENT getColony() {
        return colony;
    }

    public void setColony(COLONY_MANAGMENT colony) {
        this.colony = colony;
    }

    public int getAdvancetime() {
        return advancetime;
    }

    public void setAdvancetime(int advancetime) {
        this.advancetime = advancetime;
    }
    public void advancetime(int unit)
    {
        for(int i=0;i<unit;i++)
        {
            advancetime++;
            System.out.println("current time is :"+advancetime);
            if(colony.getActiveMission()!= null && colony.getActiveMission().getStatus().equalsIgnoreCase("IN_PROGRESS"))
            {
                for(MISSON_CAPABLE agent : colony.getActiveMission().getAssignedAgents())
                {
                    agent.worksbytime();
                }
            }
            if(advancetime==4)
            {
                colony.env_change(Enviroment.Dust_storms);
            }
            if (!colony.ReqResource("oxygen", 5)) {
        System.out.println("WARNING not enough oxygen in the colony !!!");
            }
            colony.advanceMissionTime();
        }
        
        
        
        
        
    }
    
}
