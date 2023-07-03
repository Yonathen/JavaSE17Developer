package packagea;

public class Student {
	String firstName;
	String middleName;
	String lastName;

	public Student(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public Student() {
		firstName = "John";
		middleName = "";
		lastName = "Doe";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}
}
