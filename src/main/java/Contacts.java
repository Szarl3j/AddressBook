public class Contacts {
    private int Id;
    private String FirstName;
    private String Surname;
    private String phoneNumber;
    private String email;
    private String address;

    Contacts(int Id, String FirstName, String Surname, String phoneNumber, String email, String address) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.Surname = Surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    Contacts(String FirstName, String Surname, String phoneNumber, String email, String address) {
        this(nextId.getAndIncrement(), FirstName, Surname, phoneNumber, email, address);
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
}
