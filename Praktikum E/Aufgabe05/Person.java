package Aufgabe05;

import java.util.Calendar;
import java.util.Date;

public class Person {
	private String name;
	private Calendar geburtsdatum;

	public Person(String name) {
		this(name, getCalendar(new Date()));
	}
	public Person(String name, Calendar geburtsdatum) {
		setName(name);
		setGeburtdatum(geburtsdatum);
	}
	// copy-Konstruktor
	public Person(Person original) {
		this(original.getName(), original.getGeburtsdatum());
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Calendar getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtdatum(Calendar geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public int getAlter() {
		Calendar now = getCalendar(new Date());
		int diff = now.get(Calendar.YEAR) - geburtsdatum.get(Calendar.YEAR);
		if (geburtsdatum.get(Calendar.MONTH) > now.get(Calendar.MONTH) ||
				(geburtsdatum.get(Calendar.MONTH) == now.get(Calendar.MONTH)
						&& geburtsdatum.get(Calendar.DATE) > now.get(Calendar.DATE))) {
			diff--;
		}
		return diff;
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
}
