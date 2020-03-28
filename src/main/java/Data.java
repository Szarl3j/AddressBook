import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private File file;

    public Data(String MyContacts) {
        this.file = new File("My Contacts.txt");
    }

    public Data(File file) {
        this.file = file;
    }

    public void saveContactToFile(Contact contact) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(contact.getFirstName() + "\r\n" + contact.getSurname() + "\r\n" + contact.getPhoneNumber() + "\r\n"
                    + contact.getEmail() + "\r\n" + contact.getAddress() + "\r\n\r\n");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<Contact> loadAllContacts() throws IOException {
        List<Contact> contacts = new ArrayList<Contact>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String name = null;
            while ((name = br.readLine()) != null) {
                Contact contact = new Contact(name, br.readLine(), br.readLine(), br.readLine(), br.readLine());
                contacts.add(contact);
                br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return contacts;
    }
}
