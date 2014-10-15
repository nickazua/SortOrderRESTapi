package org.OrderSorter.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;


public class Order {

    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Box> boxes = new ArrayList<Box>();
    private int numOfBoxes = 0;
    private int orderNumber = 0;



    public Order() {
    }

    public Order(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void randomizeOrder() {

        int num_items = 1 + (int)(Math.random() * 50);
        String[][] item_inv = {
                {"Shoes", "shoes", "1234567"},
                {"Heels", "shoes", "1224567"},
                {"Eye liner", "beauty", "3124567"},
                {"Accessory", "accessories", "4123567"},
                {"Blender", "housewares", "5123467"},
                {"Handbag", "bags", "4345746"},
                {"beanie", "hats", "5345746"}
        };

        ArrayList<Item> randItems = new ArrayList<Item>();

        for (int i = 0; i < num_items; i++) {
            int rand_num = (int)(Math.random() * item_inv.length);
            Item random_item = new Item(item_inv[rand_num][0], item_inv[rand_num][1], item_inv[rand_num][2]);
            randItems.add(random_item);

        }

        this.items = randItems;
    }

    public HashMap<String, ArrayList<Item>> sortByType() {

        HashMap<String, ArrayList<Item>> itemsByType = new HashMap<String, ArrayList<Item>>();

        for (Item item : this.getItems()) {
            if(itemsByType.containsKey(item.getItemType())) {
                itemsByType.get(item.getItemType()).add(item);
            } else {
                ArrayList<Item> typeItems = new ArrayList<Item>();
                typeItems.add(item);
                itemsByType.put(item.getItemType(), typeItems);
            }
        }

        return itemsByType;
    }

    public ArrayList<Item> sortDescBySize() {
        ArrayList<Item> sorted_items = this.items;

        Collections.sort(sorted_items);

        for (Item i : sorted_items) {
            System.out.println(i.getName() + " " + i.getSize());
        }

        return sorted_items;

    }

    public void sizeItems() {
        for (Item item : this.getItems()) {
            String itemType = item.getItemType().toLowerCase();

//            if (itemType.equals("shoes") || itemType.equals("bags")) {
            if (itemType.equals("shoes")) {
                item.setSize(3);

            } else if (itemType.equals("hats") || itemType.equals("clothing") ||itemType.equals("beauty")) {
                item.setSize(2);

            } else if (itemType.equals("accessories")) {
                item.setSize(1);

            } else if (itemType.equals("housewares")) {
                item.setSize(5);

            } else if (itemType.equals("bags")) {
                item.setSize(4);
            }

        }
    }


    public void boxOrder(HashMap<String,ArrayList<Item>> itemsByType) {
//       ArrayList<Box> boxes = new ArrayList<Box>();
        int boxNum = 0;

        for(String type : itemsByType.keySet()) {

            ArrayList<Item> typeItems = itemsByType.get(type);
            int maxItems = Box.CAPACITY / typeItems.get(0).getSize();

            // Creates a box and loops so long as there is space in the box
            for (int i = 0; i < typeItems.size(); i += maxItems) {
                Box box = new Box();
                boxNum++;
                box.setBoxId(boxNum);
                System.out.println( "Created New Box " + boxNum);
                System.out.println( "type: " + type + " MaxItems: " + maxItems + " Items size: " + typeItems.size() + " i: " + i);
                for (int y = i; y < i + maxItems && y < typeItems.size(); y++ )
                {
                    box.addItem(typeItems.get(y));
                    System.out.println( "add item " + typeItems.get(y).getName() + " to box");
                }
                this.boxes.add(box);

            }
            System.out.println( "out of for loop");

        }
        setNumOfBoxes(boxNum);
        System.out.println("Number of boxes: " + numOfBoxes);

//        HashMap<String, ArrayList<Box>> mapBoxes = new HashMap<String, ArrayList<Box>>();
//        mapBoxes.put("boxes", boxes);
//        return mapBoxes;
    }

    public int getNumOfBoxes() {
        return numOfBoxes;
    }

    public void setNumOfBoxes(int numOfBoxes) {
        this.numOfBoxes = numOfBoxes;
    }

    public boolean containsHousewares() {
        
    }


}
