package com.smg;

import java.util.ArrayList;
import java.util.List;

public abstract class Table {
    List<Item> items;
    int smetka;
    int peopleCount;

    Table(){
        this.items = new ArrayList<>();
        this.peopleCount = 0;
        this.smetka = 0;
    }

    void addItem(Item newItem){
        this.items.add(newItem);
        this.smetka += newItem.price;
    }

    abstract String getType();
    abstract int getMinSmetka();
}
