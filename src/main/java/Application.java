import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    private static File file = new File ("My Contacts.txt");
    static List<Contacts> persons = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        readPersonsFromFile();
        showMenu();
    }
}
