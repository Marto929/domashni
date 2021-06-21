package com.smg;

public class Main {
    public static void main(String[] argv){
        try {
            Person Marti = new Person("Marti", 18, 20);
            Person Svetlin = new Person("Svetlin", 17, 30);
            Person Vlad = new Person("Vlad", 18, 0);
            Person Gosho = new Person("Gosho", 18, 20);

            Person Mechoka = new Person("Mechoka", 18, 100);
            Person Ivailo = new Person("Ivailo", 18, 20);
            Person Martin = new Person("Martin", 18, 250);
            Person Dragan = new Person("Dragan", 18, 1000);

            Reservation MartiR = new Reservation(Marti);
            MartiR.addPerson(Svetlin);
            MartiR.addPerson(Vlad);
            MartiR.addPerson(Gosho);

            Reservation MechokaR = new Reservation(Mechoka);
            MechokaR.addPerson(Ivailo);
            MechokaR.addPerson(Martin);
            MechokaR.addPerson(Dragan);


            Club Eleven = new Club("Eleven");
            Club Illusion = new Club("Illusion");
            Club Plaza = new Club("Plaza");
            Club Club33 = new Club("Club 33");

            Eleven.addReservation(MartiR);
            Club33.addReservation(MechokaR);

            MartiR.enter(Eleven);
            MechokaR.enter(Club33);

            MartiR.getItem("Ruski Standart", 80);
            MartiR.pay();
            MartiR.getItem("x4 Redbull", 24);
            MartiR.pay();

            MechokaR.getItem("Blue Label", 700);
            MechokaR.pay();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
