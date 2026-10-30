public  class fire_emergency extends Emergency {
    
    private LABS lab;
    private int burned;

    public fire_emergency(LABS lab, int burned) {
        super(lab.getLocation());
        this.lab = lab;
        this.burned = burned;
    }

    public LABS getLab() {
        return lab;
    }

    public void setLab(LABS lab) {
        this.lab = lab;
    }

    public int getBurned() {
        return burned;
    }

    public void setBurned(int burned) {
        this.burned = burned;
    }
    
    public int robotsNeeded()
    {
        return 1;
    }
    public int humansNeeded()
    {
        return 2;
    }
    public void handle(COLONY_MANAGMENT colony)
    {    lab.setOP_STAT(false);
        colony.LocalEmergency("oxygen", burned, lab);
        for (MISSON_CAPABLE agent : colony.getAgents()) {
    if (agent.get_location().equalsIgnoreCase(getLocation()) && !agent.isrobot()) {
        agent.set_health("Injured");
        System.out.println("A person in " + getLocation() + " was injured and needs medical assistance");
    }
}
      if(!getresponders(colony,"fire"))
      {
        return ;
  
      }
     if (!colony.ReqResource("spare parts", 3))
    {
    responders_unavailable("Not enough spare parts to repair fire damage");
    return;
    }
    lab.setOP_STAT(true);
    setStatus("RESOLVED");
    System.out.println("fire at "+lab.getLocation()+"is repaired ");


    }
    
}
