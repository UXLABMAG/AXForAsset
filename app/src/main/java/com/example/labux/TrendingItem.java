package com.example.labux;

public class TrendingItem {
    private int imageResId;
    private String text;

    public TrendingItem(int imageResId, String text) {
        this.imageResId = imageResId;
        this.text = text;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getText() {
        return text;
    }


}
