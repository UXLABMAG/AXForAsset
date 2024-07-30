package com.example.labux;

import java.util.ArrayList;

public class Item {
    private int item_name;
    private int item_desc;
    private int item_detail_desc;
    private int item_image;
    public static ArrayList<Item> items = new ArrayList<>();

    public Item(int item_name, int item_desc, int item_detail_desc, int item_image) {
        this.item_name = item_name;
        this.item_desc = item_desc;
        this.item_detail_desc = item_detail_desc;
        this.item_image = item_image;

        items.add(this);
    }

    public int getItem_name() {
        return item_name;
    }

    public int getItem_desc() {
        return item_desc;
    }

    public int getItem_detail_desc() {
        return item_detail_desc;
    }

    public int getItem_image() {
        return item_image;
    }
}
