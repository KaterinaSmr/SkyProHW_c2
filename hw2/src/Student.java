public abstract class Student {
    private String firstName;
    private String lastName;

    public Student(String name) {
        String[] fullName = name.split(" ");
        this.firstName = fullName[0];
        this.lastName = fullName.length > 1 ? fullName[fullName.length-1] : "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
