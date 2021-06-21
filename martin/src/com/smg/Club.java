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

    void addGroup(Group newGroup) throws Exception {
        for (Person currentPerson : newGroup.people){
            System.out.println(currentPerson.getName() + " vleze v " + this.name + " (-5lv   ostanali pari: " + (currentPerson.getMoney() - 5) + ")");
        }
        if (newGroup.people.size() > 12){
            throw new Exception("Ne mojem da nastanim poveche ot 12 choveka");
        }
        else if (newGroup.people.size() > 3){
            newGroup.table = new Separe();
        }
        else{
            newGroup.table = new Shturkel();
        }
        System.out.println("Vie bqhte nastaneni na " + newGroup.table.getType());
        this.groups.add(newGroup);

    }
}
