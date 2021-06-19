package com.smg;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Person> people;
    float smetka;

    Group(){
        this.people = new ArrayList<>();
        this.smetka = 0;
    }

    void addPerson(Person newPerson){
        this.people.add(newPerson);
    }
}
