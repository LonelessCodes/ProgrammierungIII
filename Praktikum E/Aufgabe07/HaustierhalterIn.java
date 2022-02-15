package Aufgabe07;

import java.util.Arrays;

public class HaustierhalterIn {
    private Haustier[] meineHaustiere;

    public HaustierhalterIn() {
        meineHaustiere = new Haustier[]{};
    }

    public void neuesHaustier(Haustier haustier) {
        // Mache eine Kopie des Arrays, welches um 1 länger ist
        meineHaustiere = Arrays.copyOf(meineHaustiere, meineHaustiere.length + 1);
        meineHaustiere[meineHaustiere.length - 1] = haustier;
    }

    public void entferneHaustier(Haustier haustier) {
        int i = 0;
        while (!meineHaustiere[i].equals(haustier)) i++;
        if (i == meineHaustiere.length) return;

        entferneHaustier(i);
    }
    public void entferneHaustier(int haustierIndex) {
        if (haustierIndex >= meineHaustiere.length || haustierIndex < 0) return;

        Haustier[] neuesArray = new Haustier[meineHaustiere.length - 1];
        // Übertrage alle Haustiere vor dem Index
        for (int i = 0; i < haustierIndex; i++) {
            neuesArray[i] = meineHaustiere[i];
        }
        // Übertrage alle Haustiere nach dem Index
        for (int i = haustierIndex + 1; i < meineHaustiere.length; i++) {
            neuesArray[i - 1] = meineHaustiere[i];
        }
    }

    public String[] getHaustierBezeichnung() {
        String[] bezeichnungen = new String[meineHaustiere.length];
        for (int i = 0; i < meineHaustiere.length; i++) {
            bezeichnungen[i] = meineHaustiere[i].getBezeichnung();
        }
        return bezeichnungen;
    }
}
