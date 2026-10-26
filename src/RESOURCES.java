public class RESOURCES {
    private String resourceName;
    private int resourceQuantity;

    public RESOURCES(String resourceName, int resourceQuanitiy) {
        if(resourceQuanitiy < 0){
            throw new IllegalArgumentException("resource amount can't be negative");
        }
        this.resourceName = resourceName;
        this.resourceQuantity = resourceQuanitiy;
    }

    public String getResourceName() {
        return resourceName;
    }

    public int getResourceQuanitiy() {
        return resourceQuantity;
    }
    public boolean consume(int quantity){
        if(quantity <= 0 || quantity > resourceQuantity){
            return false;
        }
        resourceQuantity -= quantity;
        return true;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setResourceQuantity(int resourceQuantity) {
        this.resourceQuantity = resourceQuantity;
    }
    public boolean hasEnough(int quantity){
        return quantity > 0 || quantity < resourceQuantity;
    }
}
