package org.OrderSorter.Domain;

import java.util.ArrayList;
import java.util.Collections;

public class Sorter {

    public Sorter() {

    }

    public ArrayList<Box> fillBoxesToMaxCapacity(ArrayList<Item> orderItems) {
        ArrayList<Box> boxList = new ArrayList<Box>(); // make a list of boxes

        // sort the items by their size in descending order
        sortDescBySize(orderItems);

        // make a new list for items that we put in boxes
        ArrayList<Item> itemsAdded = new ArrayList<Item>();

        int boxNum = 1; // start with box 1

        // while there are still items left to place in boxes...
        while (itemsAdded.size() != orderItems.size()) {
            Box currentBox = new Box();
            currentBox.setBoxId(boxNum);

            int boxCapacity = Box.CAPACITY;

            // try to fit every item in this box
            for (Item currentItem : orderItems) {
                if (itemsAdded.contains(currentItem)) { // has this item been added already?
                    continue; // skip this item, it's already been added to a box
                }

                int currentItemSize = currentItem.getSize(); // get item size

                if (currentItemSize <= boxCapacity) { // does the item fit in the box?
                    currentBox.addItem(currentItem); // Add item to box
                    boxCapacity = boxCapacity - currentItemSize; // Remove item size from box capacity
                    itemsAdded.add(currentItem); // add item to the list of items in boxes so it's not added again
                }
            }

            boxList.add(currentBox);
            boxNum++;
        }

        return boxList;
    }

    public ArrayList<Item> sortDescBySize(ArrayList<Item> items) {
        Collections.sort(items);
        return items;
    }
}
