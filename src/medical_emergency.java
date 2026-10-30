
import java.util.ArrayList;

public   class medical_emergency extends Emergency {
private HUMAN_PERSONNEL patient;
private FACILITIES facility;

    public medical_emergency(HUMAN_PERSONNEL patient, FACILITIES facility) {
        super(patient.get_location());
        this.patient = patient;
        this.facility = facility;
    }

    public HUMAN_PERSONNEL getPatient() {
        return patient;
    }

    public void setPatient(HUMAN_PERSONNEL patient) {
        this.patient = patient;
    }

    public FACILITIES getFacility() {
        return facility;
    }

    public void setFacility(FACILITIES facility) {
        this.facility = facility;
    }
    public int humansNeeded()
    {
        return 1;
        
        
    }
    public int robotsNeeded()
    {
        return 0;
    }
   public void handle(COLONY_MANAGMENT colony)
   {
        if (!facility.isOP_STAT()) {
        responders_unavailable("Facility " + getLocation() + " is not operational");
        return;
    }
        if(!getresponders(colony,"MEDICAL"))
        {
            return;
        }
        if(!colony.ReqResource("medical supplies", 2))
        {
            responders_unavailable("not enough medical supplies ");
            return;
        }
    patient.set_health("Healthy");
    setStatus("RESOLVED");
    System.out.println("Patient treated at " + facility.getLocation() + ", Health is now " + patient.getHealth_Stat());
       
       
   }
    
    
}
