package com.smg;

import java.util.ArrayList;
import java.util.List;

public class Reservation{
    Person owner;
    List<Person> others;

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
        Group inside = new Group();

        for (Person currentPerson : this.others){
            if (currentPerson.getAge() < 18){
                System.out.println(currentPerson.getName() + ", nqmash 18 godini!");
                boolean give20 = false;
                // shte pita choveka dali iska da dade 20 lv za da vleze
                // proverka dali ima 20 lv
                // eventualno go dobavq v toEnter
            }
            else{
                toEnter.add(currentPerson);
            }
        }

        for (Person currentPerson : toEnter){
            if (currentPerson.getMoney() < 5){
                System.out.println(currentPerson.getName() + ", nqmash 5 lv za vhod!");
            }
            else{
                inside.addPerson(currentPerson);
            }
        }

        club.addGroup(inside);
    }

}
