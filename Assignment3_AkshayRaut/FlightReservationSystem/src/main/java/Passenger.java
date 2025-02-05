public class Passenger {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String travelClass;
    private String confirmationNumber;

    public Passenger(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.travelClass = travelClass;
        this.confirmationNumber = confirmationNumber;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }
}