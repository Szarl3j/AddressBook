import java.util.concurrent.atomic.AtomicInteger;

public class Contact {
    private static AtomicInteger nextID = new AtomicInteger(1);
    private int Id;
    private String FirstName;
    private String Surname;
    private String phoneNumber;
    private String email;
    private String address;

    Contact(int Id, String FirstName, String Surname, String phoneNumber, String email, String address) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.Surname = Surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    Contact(String FirstName, String Surname, String phoneNumber, String email, String address) {
        this(nextID.getAndIncrement(), FirstName, Surname, phoneNumber, email, address);
    }

    int getId() {
        return Id;
    }

    String getFirstName() {
        return FirstName;
    }

    String getSurname() {
        return Surname;
    }

    String
    getPhoneNumber() {
        return phoneNumber;
    }
    String getEmail(){
        return email;
    }
    String getAddress(){
        return address;
    }

    @Override
    public String toString() {
        return"\n\nId: " + getId() + "\nName: " + getFirstName() + "\nSurname: " + getSurname() + "\nPhone number: "
                + getPhoneNumber() + "\nEmail: "  +getEmail() + "\nAddress: " + getAddress();
    }

    public static void setNextID(AtomicInteger nextID) {
        Contact.nextID = nextID;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
