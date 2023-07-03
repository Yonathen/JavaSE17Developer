package packageb;

import packagea.*;

public class Record {
	public static void main(String[] args) {
		Student s1 = new Student(args[0], args[1], args[2]);
		Student s2 = new Student();
		System.out.println(s2.getFirstName() + " " + s2.getMiddleName() + " " + s2.getLastName());
		System.out.println(s1.getFirstName() + " " + s1.getMiddleName() + " " + s1.getLastName());
	}
}
