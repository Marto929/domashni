package com.smg;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Person> people;
    Table table;

    Group(){
        this.people = new ArrayList<>();
    }

    void addPerson(Person newPerson){
        this.people.add(newPerson);
    }

    void addItem(Item newItem){
        this.table.addItem(newItem);
        System.out.println("Vie dobavihte " + newItem.name + "(" + newItem.price + ") kum smetkata si (Smetka do momenta: " + this.table.smetka + ")");
    }

    void pay(){
        if (this.table.getMinSmetka() > table.smetka){
            System.out.println("Minimalnata smetka za masata e " + this.table.getMinSmetka() + "! Trqba da q pokriete");
            return;
        }
        int debt = 0;
        int pricePerPerson = this.table.smetka / this.people.size();
        System.out.println("Vseki ot masata trqbva da plati po " + pricePerPerson + " za smetkata");
        for (Person currentPerson : this.people){
            if (currentPerson.getMoney() < pricePerPerson){
                System.out.println(currentPerson.getName() + " nqma dostatuchno pari za smetkata(" + currentPerson.getMoney() + ")");
                currentPerson.setMoney(0);
                debt += (pricePerPerson - currentPerson.getMoney());
            }
            else{
                currentPerson.setMoney(currentPerson.getMoney() - pricePerPerson);
                System.out.println(currentPerson.getName() + " dade pari za smetkata(ostanali pari: " + currentPerson.getMoney() + ")");
                if (debt > 0){
                    if (debt > currentPerson.getMoney()){
                        System.out.println(currentPerson.getName() + " dava ostanalite si pari za smetkata - " + currentPerson.getMoney());
                        debt -= currentPerson.getMoney();
                        currentPerson.setMoney(0);
                    }
                    else{
                        System.out.println(currentPerson.getName() + " dava dopulnitelno pari za smetkata - " + debt);
                        currentPerson.setMoney(currentPerson.getMoney() - debt);
                        debt = 0;
                    }
                }
            }
        }
        String out = " ";
        for (Person currentPerson : this.people){
            out += currentPerson.getName() + " ";
        }

        if (debt > 0){
            System.out.println(out + "ne uspqha da si platqt smetkata");
            System.out.println("servitiora dava signal na ohranata");
            System.out.println("ohranata idva kum vas");
            System.out.println("*Tsvetelina Yaneva - Boi Boi starts playing in the background*");
            System.out.println("TO BE CONTINUED");
        }
        else{
            System.out.println(out + "zaplatiha smetkata si");
        }

    }
}
