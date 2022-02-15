package Aufgabe02;

public abstract class Person {
    private String name;
    private String vorname;

    public Person(String name, String vorname) {
        setName(name);
        setVorname(vorname);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
