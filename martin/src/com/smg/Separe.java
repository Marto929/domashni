package com.smg;

public class Separe extends Table{
    final int max = 12;
    final int minSmetka = 250;

    @Override
    String getType(){
        return "Separe";
    }

    @Override
    int getMinSmetka() {
        return this.minSmetka;
    }
}
