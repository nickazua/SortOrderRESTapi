package org.OrderSorter.Domain;

import java.util.ArrayList;

public class Box {
    private ArrayList<Item> boxItems = new ArrayList<Item>();
    private int boxId;
    public static final int CAPACITY = 9;
    private int currentCapacity = 0;

    public ArrayList<Item> getBoxItems() {
        return boxItems;
    }

    public void setBoxItems(ArrayList<Item> boxItems) {
        this.boxItems = boxItems;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public void addItem(Item item) {
        boxItems.add(item);
        currentCapacity += item.getSize();
    }

    public Item removeLastItem() {
        Item removed_item = boxItems.remove(boxItems.size() - 1);
        currentCapacity -= removed_item.getSize();
        return removed_item;
    }
    public Item removeFirstItem() {
        Item removed_item = boxItems.remove(0);
        currentCapacity -= removed_item.getSize();
        return removed_item;
    }

    public boolean isFull() {
        return CAPACITY == currentCapacity;
    }

}
