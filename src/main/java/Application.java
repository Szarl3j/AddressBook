import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    private static File file = new File ("My Contacts.txt");
    static List<Contact> persons = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        readPersonsFromFile();
        showMenu();
    }
    private static void searchContact() throws IOException{
        System.out.println("1. Search by name ");
        System.out.println("2. Search by surname ");

        String option;
        do {
            option = sc.nextLine();
            switch(option){
                case "1":
                    searchByName();
                    break;
                case "2":
                    searchBySurname();
                    break;
                default:
                    System.out.println("Choose 1st or 2nd option ");
            }
        }while (!option.equals("1" )&& !option.equals("2"));
        System.out.println();
        showMenu();
    }
    private static void searchBySurname(){
        System.out.println(" Put surname ");
        String surnameToSearch = sc.nextLine();
        int matches = 0;
        for (Contact contact : persons){
            if (contact.getSurname().equals(surnameToSearch)){
                System.out.println(contact);
                matches++;
            }
        }
        if (matches<= 0){
            System.out.println(" Contact with this surname didn't exists ");
        }
    }
    private static void searchByName(){
        System.out.println(" Put name ");
        String nameToSearch = sc.nextLine();
        int matches= 0;
       for (Contact contact :persons){
           if (contact.getFirstName().equals(nameToSearch));
           System.out.println(contact);
           matches++;
       }
       if (matches<= 0);
        System.out.println(" Contact with this firstname didn't exists ");
    }
    private static void addContact() throws IOException{
        System.out.println(" Put name ");
        String name = sc.nextLine();
        System.out.println(" Put surname ");
        String surname =sc.nextLine();
        System.out.println(" Put phone number ");
        String phoneNumber = sc.nextLine();
        System.out.println(" Put e-mail address ");
        String email = sc.nextLine();
        System.out.println(" Put address ");
        String address = sc.nextLine();

        Contact contact = new Contact(name,surname,phoneNumber,email,address);
        addToFile(contact);
        persons.add(contact);
        System.out.println(" Added contact with number "+ contact.getId() + contact);
        System.out.println();
        showMenu;

    }
}