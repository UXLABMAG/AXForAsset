package com.example.labux;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Item implements Parcelable {
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

    protected Item(Parcel in) {
        item_name = in.readInt();
        item_desc = in.readInt();
        item_detail_desc = in.readInt();
        item_image = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(item_name);
        dest.writeInt(item_desc);
        dest.writeInt(item_detail_desc);
        dest.writeInt(item_image);
    }
}
