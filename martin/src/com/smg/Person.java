package com.smg;

public class Person {
    private String name;
    private int age;
    private int money;

    Person(String name, int age, int money){
        this.name = name;
        this.age = age;
        this.money = money;
    }

    String getName(){
        return this.name;
    }

    int getAge(){
        return this.age;
    }

    int getMoney(){
        return this.money;
    }

    void enter (Club club){
        for (Reservation currentReservation : club.reservations){
            for (Person currentPerson : currentReservation.others){
                if (currentPerson.equals(this)){
                    try {
                        currentReservation.enter(club);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
