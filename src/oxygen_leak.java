
public  class oxygen_leak extends Emergency {

    private HABITAT habitat;
    private int leak_amount ;
    public oxygen_leak(HABITAT habitat, int leak_amount) {
        super(habitat.getLocation());
        this.habitat = habitat;
        this.leak_amount = leak_amount;
}

    public HABITAT getHabitat() {
        return habitat;
    }

    public void setHabitat(HABITAT habitat) {
        this.habitat = habitat;
    }

    public int getLeak_amount() {
        return leak_amount;
    }

    public void setLeak_amount(int leak_amount) {
        this.leak_amount = leak_amount;
    }
    public int humansNeeded()
    {
        return 1;
    }
    public int robotsNeeded()
    {
        return 1;
        
    }
    public void handle(COLONY_MANAGMENT colony)
    {
        colony.LocalEmergency("oxygen", leak_amount, habitat);
        if(!getresponders( colony, "OXYGEN_LEAK"))
        {    
            colony.LocalEmergency("oxygen", leak_amount, habitat);
            return;
        }
        else
        {
           if(!colony.ReqResource("spare parts", leak_amount))
           {
            responders_unavailable("not enough spare parts to repair");
            colony.LocalEmergency("oxygen", leak_amount, habitat);
            return ;
           }
           setStatus("RESOLVED");
            System.out.println("leak is repaired ... oxygen now is "+habitat.getResource("oxygen")+"in"+habitat.getLocation());
        }

    }
    
    
    
    
    
    
    
}


