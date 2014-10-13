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
            if (!remaining_items.isEmpty()) {
                moveRemaining_itemsToUnboxed_items();
            }

            unboxed_items = sortDescBySize(unboxed_items);

            while (!unboxed_items.isEmpty()) {
                boxNum++;

//                Box box = new Box();
//                box.addItem(unboxed_items.remove(0));
//                int loopcount = 0;
//                while (loopcount < unboxed_items.size() && box.getCurrentCapacity() != max) {
//                    if (box.getCurrentCapacity() + unboxed_items.get(loopcount).getSize() <= max) {
//                        box.addItem(unboxed_items.remove(loopcount));
//                    } else {
//                        loopcount++;
//                    }
//                }
                Box box = fillBoxDescendingMax(unboxed_items, max);

                if (box.getCurrentCapacity() != max) {
                    moveSmallerItemsToUnboxed(box);

                    sortUnboxed_itemsDesc();

                    for (int i = unboxed_items.size() - 1; i >= 0; i--) {
                        if (box.getCurrentCapacity() + unboxed_items.get(i).getSize() <= max) {
                            box.addItem(unboxed_items.remove(i));

                            for (int j = 0; j < unboxed_items.size(); j++) {
                                if (box.getCurrentCapacity() + unboxed_items.get(j).getSize() <= max) {
                                    box.addItem(unboxed_items.remove(j));
                                    j--;
                                    i--;
                                }

                                if (box.getCurrentCapacity() == max) {
                                    break;
                                }
                            }
                        }

                        if (unboxed_items.size() == 0) {
                            break;
                        }
                    }
                }

                if (box.getCurrentCapacity() < max) {
                    remaining_items.add(box.removeFirstItem());
                    moveBoxItemsToUnboxed_items(box);
                    boxNum--;
                } else if (box.getCurrentCapacity() == max) {
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
            if (box.getCurrentCapacity() + items.get(loopcount).getSize() <= max) {
                box.addItem(items.remove(loopcount));
            } else {
                loopcount++;
            }
        }

        return box;
    }

}
