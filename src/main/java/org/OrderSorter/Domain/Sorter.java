package org.OrderSorter.Domain;

import java.util.ArrayList;
import java.util.Collections;

public class Sorter {
    private ArrayList<Item> unboxed_items;
    private ArrayList<Item> remaining_items;

    public Sorter() {
        remaining_items = new ArrayList<Item>();
    }
    public ArrayList<Item> getUnboxed_items() {
        return unboxed_items;
    }

    public void setUnboxed_items(ArrayList<Item> unboxed_items) {
        this.unboxed_items = new ArrayList<Item>(unboxed_items);
    }

    public ArrayList<Item> getRemaining_items() {
        return remaining_items;
    }

    public void setRemaining_items(ArrayList<Item> remaining_items) {
        this.remaining_items = remaining_items;
    }

    public void addToUnboxed_items(Item item) {
        this.unboxed_items.add(item);
    }

    public ArrayList<Box> fillBoxesToMaxCapacity(ArrayList<Item> order_items) {
        ArrayList<Box> boxed_items = new ArrayList<Box>();
        int boxNum = 0;
        int max = Box.CAPACITY;

        setUnboxed_items(order_items);

        while (!unboxed_items.isEmpty() || !remaining_items.isEmpty()) {
            moveRemaining_itemsToUnboxed_items();

            while (!unboxed_items.isEmpty()) {

                boxNum++;
                sortUnboxed_itemsDesc();
                // Fill box in with the largest possible items
                Box box = fillBoxDescendingMax(unboxed_items, max);

                // if box isn't full with largest possible return those items
                // and attempt to sort it with the largest, then smallest, then largest, and so on
                if (!box.isFull() && !unboxed_items.isEmpty()) {
                    moveSmallerItemsToUnboxed(box);
                    sortUnboxed_itemsDesc();
                    box = fillBoxAlternatingLargeSmall(box, unboxed_items, max);
                }

                // if box still not full store largest item in remaining
                // and return any other items back to unboxed
                if (box.getCurrentCapacity() < max) {
                    moveSmallerItemsToUnboxed(box);
                    remaining_items.add(box.removeFirstItem());
                    boxNum--;
                }
                // if full store box
                else if (box.getCurrentCapacity() == max) {
                    box.setBoxId(boxNum);
                    boxed_items.add(box);
                }
            }
            max--;
        }
        return boxed_items;
    }

    public void moveRemaining_itemsToUnboxed_items() {
        while (!remaining_items.isEmpty()) {
            addToUnboxed_items(remaining_items.remove(0));
        }
    }

    public void moveBoxItemsToUnboxed_items(Box box) {
        while (!box.getBoxItems().isEmpty()) {
            addToUnboxed_items(box.removeFirstItem());
        }
    }

    public void moveSmallerItemsToUnboxed(Box box) {
        while (box.getBoxItems().size() > 1) {
            addToUnboxed_items(box.removeLastItem());
        }
    }

    public ArrayList<Item> sortDescBySize(ArrayList<Item> items) {
        Collections.sort(items);
        return items;
    }

    public void sortUnboxed_itemsDesc() {
        Collections.sort(this.unboxed_items);
    }

    public Box fillBoxDescendingMax(ArrayList<Item> items, int max) {
        Box box = new Box();

        box.addItem(items.remove(0));

        int loopcount = 0;
        while (loopcount < items.size() && box.getCurrentCapacity() != max) {
            if (checkFitItemBox(box, max, loopcount)) {
                box.addItem(items.remove(loopcount));
            } else {
                loopcount++;
            }
        }

        return box;
    }

    public Box fillBoxAlternatingLargeSmall(Box box, ArrayList<Item> items, int max) {
        int small_loop = items.size() - 1;
        int big_loop = 0;

        while (small_loop >= 0 && items.size() != 0 && !box.isFull()) {
            if (checkFitItemBox(box, max, small_loop)) {
                box.addItem(items.remove(small_loop));

                while (big_loop < items.size() && !box.isFull()) {
                    if (checkFitItemBox(box, max, big_loop)) {
                        box.addItem(items.remove(big_loop));
                        big_loop--;
                        small_loop--;
                    }
                    big_loop++;
                }
            }
            small_loop--;
        }
        return box;
    }

    public boolean checkFitItemBox(Box box, int max, int item_position) {
        if (box.getCurrentCapacity() + unboxed_items.get(item_position).getSize() <= max) {
            return true;
        }
        return false;
    }

}
