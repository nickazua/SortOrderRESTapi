package org.OrderSorter.Domain;

public class Item implements Comparable<Item> {

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


    @Override
    public int compareTo(Item compare_item) {
        int compare_size = ((Item)compare_item).getSize();
        // Ascending order
        // return this.size - compare_size;
        // Descending order
        return compare_size - this.size;
    }
}
