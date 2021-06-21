package com.smg;

public class Shturkel extends Table {
    final int max = 3;
    final int minSmetka = 100;

    @Override
    String getType(){
        return "Shturkel";
    }

    @Override
    int getMinSmetka() {
        return this.minSmetka;
    }
}
