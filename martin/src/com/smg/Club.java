package com.smg;

import java.util.ArrayList;
import java.util.List;

public class Club {
    String name;
    List<Reservation> reservations;
    List<Group> groups;

    Club (String name){
        this.name = name;
        this.reservations = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    void addReservation(Reservation newReservation){
        this.reservations.add(newReservation);
    }

    void addGroup(Group newGroup){
        for (Person currentPerson : newGroup.people){
            System.out.println(currentPerson.getName() + " vleze v " + this.name + " (-5lv   ostanali pari: " + (currentPerson.getMoney() - 5) + ")");
        }
        this.groups.add(newGroup);
    }
}
