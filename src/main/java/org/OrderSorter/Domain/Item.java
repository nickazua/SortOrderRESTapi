package org.OrderSorter.Domain;

public class Item {

    private String name;
    private String itemType;
    private String sku;
    private int size;

    public Item(){

    }
    public Item(String name, String itemType, String sku) {
        this.name = new String(name);
        this.itemType = new String(itemType);
        this.sku = new String(sku);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return this.name;
    }

    public String getItemType(){
        return this.itemType;
    }

    public String getSku() {
        return this.sku;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
