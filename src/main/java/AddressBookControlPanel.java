import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookControlPanel {
    private int Id;

    private enum Action {
        ADD_CONTACT,
        SEARCH_CONTACT,
        DISPLAY_ALL_CONTACTS,
        EDIT_CONTACT,
        DELETE_CONTACT,
        EXIT
    }

    private enum Options {
        First_Name,
        Surname,
    }

    private Data data;
    private Scanner sc;
    private List<Contact> contacts;

    public AddressBookControlPanel(Data data) {
        sc = new Scanner(System.in);
        this.data = data;
        try {
            contacts = data.loadAllContacts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AddressBookControlPanel(String MyContacts) {
        this(new Data(MyContacts));
    }

    public AddressBookControlPanel(File file) {
        this(new Data(file));
    }

    private List<Contact> searchContact(String searchString, Options options) {
        switch (options) {
            case First_Name:
                return contacts.stream().filter(person ->
                        person.getSurname().equals(searchString)).collect(Collectors.toList());
            case Surname:
                return contacts.stream().filter(person ->
                        person.getFirstName().equals(searchString)).collect(Collectors.toList());
            default:
                System.out.println("Invalid filter option");
                return new ArrayList<>();
        }
    }

    public void start() {
        while (true) {
            Action option = showMenuAndChoose();
            switch (option) {
                case ADD_CONTACT:
                    Contact contact = getContactInformation();
                    data.saveContactToFile(contact);
                    contacts.add(contact);
                    break;
                case EDIT_CONTACT:
                    System.out.println("Put index number which you want edit ");
                    int index = sc.nextInt() - 1;
                    sc.nextLine();
                    fillContactInformation(contacts.get(index));
                    System.out.println("Contact's list are updated.");
                    break;
                case SEARCH_CONTACT:
                    Options selectedFilter = showFindPersonFilterOptionsAndGetSelection();
                    System.out.print("Enter name: ");
                    String searchString = sc.nextLine();
                    List<Contact> filteredContacts = searchContact(searchString, selectedFilter);
                    if (filteredContacts.size() == 0) {
                        System.out.println("No matches");
                    } else {
                        for (Contact c : filteredContacts)
                            System.out.println(c);
                        break;
                    }
                case DISPLAY_ALL_CONTACTS:
                    System.out.println(this.contacts);
                    System.out.println();
                    break;
                case DELETE_CONTACT:
                    System.out.println("Put id number which you want delete ");
                    int Index = sc.nextInt() - 1;
                    sc.nextLine();
                    fillContactInformation(contacts.get(Index));
                    System.out.println("Contact is removed from the list.");
                    System.out.println("Contact's list are updated.");
                    break;
                case EXIT:
                    System.out.println(" Program is closed. ");
                    System.exit(0);
                    break;
            }
        }
    }

    private Action showMenuAndChoose() {
        System.out.println(" 1. Add new contact ");
        System.out.println(" 2. Edit exisisted contact");
        System.out.println(" 3. Search contact ");
        System.out.println(" 4. Show all contacts ");
        System.out.println(" 5. Delete contact ");
        System.out.println(" 6. Close program ");
        String option;
        option = sc.nextLine();
        switch (option) {
            case "1":
                return Action.ADD_CONTACT;
            case "2":
                return Action.EDIT_CONTACT;
            case "3":
                return Action.SEARCH_CONTACT;
            case "4":
                return Action.DISPLAY_ALL_CONTACTS;
            case "5":
                return Action.DELETE_CONTACT;
            case "6":
                return Action.EXIT;
            default:
                System.out.println(" Choose number from 1 to 6 ");
        }
        while (!option.equals("6")) ;
        return null;
    }

    private Contact getContactInformation() {
        System.out.println(" Put name ");
        String firstName = sc.nextLine();
        System.out.println(" Put surname ");
        String surname = sc.nextLine();
        System.out.println(" Put phone number ");
        String phoneNumber = sc.nextLine();
        System.out.println(" Put e-mail address ");
        String email = sc.nextLine();
        System.out.println(" Put address ");
        String address = sc.nextLine();
        return new Contact(firstName, surname, phoneNumber, email, address);
    }

    private Options showFindPersonFilterOptionsAndGetSelection() {
        System.out.println(" 1. Search by name ");
        System.out.println(" 2. Search by surname ");
        System.out.println();
        String option;
        do {
            option = sc.nextLine();
            switch (option) {
                case "1":
                    return Options.First_Name;
                case "2":
                    return Options.Surname;
                default:
                    System.out.println(" Choose number 1 or 2 ");
            }
        } while (option.equals("1") && option.equals("2"));
        return null;
    }

    private List<Contact> editContact() {
        List<Contact> contacts = editContact();
        int id = Integer.parseInt(String.valueOf(Id));
        id = sc.nextInt() - 1;
        sc.nextLine();
        fillContactInformation(contacts.get(id));
        System.out.println("Contact's list are updated.");
        return contacts;
    }

    private Contact fillContactInformation(Contact contacts) {
        System.out.println("Put first name:");
        String name = sc.nextLine();
        System.out.println("Put surname:");
        String surname = sc.nextLine();
        System.out.println("Put phone number:");
        String phoneNumber = sc.nextLine();
        System.out.println("Put email address:");
        String email = sc.nextLine();
        System.out.println("Put address:");
        String address = sc.nextLine();

        contacts.setFirstName(name);
        contacts.setSurname(surname);
        contacts.setAddress(address);
        contacts.setPhoneNumber(phoneNumber);
        contacts.setEmail(email);
        return contacts;
    }

    private List<Contact> deleteContactFromList() {
        List<Contact> contacts = deleteContactFromList();
        System.out.println("Contact is removed from the list.");
        System.out.println("Contact's list are updated.");
        return contacts;

    }
}
