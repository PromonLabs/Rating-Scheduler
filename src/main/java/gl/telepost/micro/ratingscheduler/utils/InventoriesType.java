package gl.telepost.micro.ratingscheduler.utils;

import gl.telepost.micro.ratingscheduler.db.models.InventoryType;

import java.util.ArrayList;
import java.util.List;

public class InventoriesType
{
    protected List<InventoryType> inventory;

    public List<InventoryType> getInventory() {
        if (inventory == null) {
            inventory = new ArrayList<InventoryType>();
        }
        return this.inventory;
    }
}
