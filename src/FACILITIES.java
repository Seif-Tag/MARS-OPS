import java.util.ArrayList;


public class FACILITIES {
    protected String location;
    protected float capacitiy;
    protected boolean OP_STAT;
    protected ArrayList<RESOURCES> resources;
    protected ArrayList<EQUIPMENT> equipment;

    public FACILITIES(String location, float capacitiy, boolean OP_STAT) {
        this.location = location;
        this.capacitiy = capacitiy;
        this.OP_STAT = OP_STAT;
        this.resources= new ArrayList<>();
        this.equipment= new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }
    public void addResource(RESOURCES resource){
        resources.add(resource);
    }
    public RESOURCES getResource(String name){
        for(RESOURCES resource : resources){
            if(resource.getResourceName().equalsIgnoreCase(name))
                return resource;
        }
        return null;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getCapacitiy() {
        return capacitiy;
    }

    public void setCapacitiy(float capacitiy) {
        this.capacitiy = capacitiy;
    }

    public boolean isOP_STAT() {
        return OP_STAT;
    }

    public void setOP_STAT(boolean OP_STAT) {
        this.OP_STAT = OP_STAT;
    }
    public void addEquipment(EQUIPMENT item){
        equipment.add(item);
    }
    public EQUIPMENT getEquipment(String name){
        for(EQUIPMENT equipment : equipment){
            if(equipment.getEquipmentName().equalsIgnoreCase(name))
                return equipment;
        }
        return null;
    }
   

   
}
