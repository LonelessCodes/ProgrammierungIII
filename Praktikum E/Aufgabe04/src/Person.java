package Aufgabe04.src;

public class Person {
	private String name;
	private int alter;

	public Person() {
		this("", 1);
	}

	public Person(String name) {
		this(name, 1);
	}

	public Person(String name, int alter) {
		setName(name);
		setAlter(alter);
	}
	
	// copy-Konstruktor
	public Person(Person original) {
		this(original.getName(), original.getAlter());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}
}
