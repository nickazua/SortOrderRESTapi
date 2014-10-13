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
                returnRemainingToUnsorted();
            }

            unboxed_items = sortDescBySize(unboxed_items);

            while (!unboxed_items.isEmpty()) {
                Box box = new Box();
                boxNum++;
                box.setBoxId(boxNum);
                box.addItem(unboxed_items.remove(0));

                int loopcount = 0;
                while (loopcount < unboxed_items.size() && box.getCurrentCapacity() != max) {
                    if (box.getCurrentCapacity() + unboxed_items.get(loopcount).getSize() <= max) {
                        box.addItem(unboxed_items.remove(loopcount));
                    } else {
                        loopcount++;
                    }
                }

                if (box.getCurrentCapacity() != max) {
                    clearBoxAddToUnsorted(box);

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
                    clearBoxAddToUnsorted(box);
                    remaining_items.add(box.removeFirstItem());
                    boxNum--;
                } else if (box.getCurrentCapacity() == max) {
                    boxed_items.add(box);
                }

            }
            max--;
        }
        return boxed_items;
    }

    public void returnRemainingToUnsorted() {
        while (!remaining_items.isEmpty()) {
            addToUnboxed_items(remaining_items.remove(0));
        }
    }

    public void clearBoxAddToUnsorted(Box box) {
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


}
