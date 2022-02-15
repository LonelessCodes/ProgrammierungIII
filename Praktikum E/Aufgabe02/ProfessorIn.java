package Aufgabe02;

public class ProfessorIn extends Person {
    private int gehalt;
    private Publikation[] publikationen;

    public ProfessorIn(String name, String vorname, int gehalt, Publikation[] publikationen) {
        super(name, vorname);
        setGehalt(gehalt);
        setPublikationen(publikationen);
    }

    public int getGehalt() {
        return gehalt;
    }
    public void setGehalt(int gehalt) throws IllegalArgumentException {
        if (gehalt < 0) {
            throw new IllegalArgumentException("Gehalt muss größer-gleich Null sein.");
        }
        this.gehalt = gehalt;
    }

    public Publikation[] getPublikationen() {
        return publikationen;
    }
    public void setPublikationen(Publikation[] publikationen) throws IllegalArgumentException {
        this.publikationen = publikationen;
    }
}
