package com.smg;

public class Main {
    public static void main(String[] argv){
        try {
            Person Marti = new Person("Marti", 18, 20);
            Person Svetlin = new Person("Svetlin", 17, 30);
            Person Mechoka = new Person("Mechoka", 18, 100);
            Person Martin = new Person("Martin", 18, 30);
            Person Vlad = new Person("Vlad", 18, 0);

            Reservation MartiR = new Reservation(Marti);
            MartiR.addPerson(Svetlin);
            MartiR.addPerson(Vlad);

            Reservation MechokaR = new Reservation(Mechoka);
            MechokaR.addPerson(Martin);

            Club Eleven = new Club("Eleven");
            Club Illusion = new Club("Illusion");
            Club Plaza = new Club("Plaza");
            Club Club33 = new Club("Club 33");

            Eleven.addReservation(MartiR);
            Club33.addReservation(MechokaR);

            MartiR.enter(Eleven);
            MechokaR.enter(Club33);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
