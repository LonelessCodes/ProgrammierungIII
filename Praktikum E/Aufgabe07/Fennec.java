package Aufgabe07;

public class Fennec implements Haustier {
    private String name;
    private int alter;

    public Fennec(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    public String getBezeichnung() {
        return "Fennec";
    }

    public String getTierstimme() {
        return "SCREAM SCREAM SCREAM";
    }
}
