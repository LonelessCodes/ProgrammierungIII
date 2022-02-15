package Aufgabe07;

public class HaustierHaushalt {
    public static void main(String[] args) {
        HaustierhalterIn heinz = new HaustierhalterIn();
        Hund rambo = new Hund("Rambo", 3);
        heinz.neuesHaustier(rambo);
        System.out.println("Haustier von Heinz: " +
                heinz.getHaustierBezeichnung());
    }
}
