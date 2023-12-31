package university;


public class Student {
    private String firstName;
    private String lastName;
    private String bestSubject;

    @Override
    public String toString() {
        return String.format("Student: %s %s, %s",getFirstName(),getLastName(),getBestSubject());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    public void setBestSubject(String bestSubject) {
        this.bestSubject = bestSubject;
    }

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }
}
