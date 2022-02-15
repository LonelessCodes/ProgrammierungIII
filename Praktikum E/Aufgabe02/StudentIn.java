package Aufgabe02;

public class StudentIn extends Person {
    private String wohnort;
    private int matrikelnummer;

    public StudentIn(String name, String vorname, String wohnort, int matrikelnummer) {
        super(name, vorname);
        setWohnort(wohnort);
        setMatrikelnummer(matrikelnummer);
    }

    public String getWohnort() {
        return wohnort;
    }
    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }
    public void setMatrikelnummer(int matrikelnummer) throws IllegalArgumentException {
        if (matrikelnummer <= 0) {
            throw new IllegalArgumentException("Matrikelnummer muss ganzzahlig und positiv sein.");
        }
        this.matrikelnummer = matrikelnummer;
    }
}
