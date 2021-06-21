package com.smg;

import java.util.ArrayList;
import java.util.List;

public class Reservation{
    Person owner;
    List<Person> others;
    Club club;

    Reservation(Person owner){
        this.owner = owner;
        this.others = new ArrayList<>();
        this.others.add(this.owner);
    }

    void addPerson(Person ... newPersons){
        for (Person currentPerson : newPersons){
            this.others.add(currentPerson);
        }
    }

    void enter(Club club) throws Exception{
        boolean hasReservation = false;
        for (Reservation currentReservation : club.reservations){
            if (currentReservation.owner.getName().equals(this.owner.getName())){
                hasReservation = true;
                break;
            }
        }

        if (!hasReservation){
            throw new Exception("Ne mojete da vlezete bez rezervaciq!\n");
        }

        ArrayList<Person> toEnter = new ArrayList<Person>();

        for (Person currentPerson : this.others){
            if (currentPerson.getAge() < 18){
                System.out.println(currentPerson.getName() + ", nqmash 18 godini!");
            }
            else{
                toEnter.add(currentPerson);
            }
        }
        Group inside = new Group();
        for (Person currentPerson : toEnter){
            if (currentPerson.getMoney() < 5){
                System.out.println(currentPerson.getName() + ", nqmash 5 lv za vhod!");
            }
            else{
                inside.addPerson(currentPerson);
            }
        }
        this.club = club;
        club.addGroup(inside);
    }

    void getItem(String name, float price) throws Exception {
        if (this.club == null){
            throw new Exception("Vse oshte ne ste vlezli v diskotekata");
        }
        for (Group currentGroup : this.club.groups){
            for (Person currentPerson : currentGroup.people){
                if (currentPerson.equals(this.owner)){
                    Item newItem = new Item(name, price);
                    System.out.println(this.owner.getName() + " porucha " + name + "(" + price + ") kum smetkata na masata");
                    currentGroup.addItem(newItem);
                }
            }
        }
    }

    void pay(){
        for (Group currentGroup : this.club.groups){
            for (Person currentPerson : currentGroup.people){
                if (currentPerson.equals(this.owner)){
                    currentGroup.pay();
                }
            }
        }
    }

}
