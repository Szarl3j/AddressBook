import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        AddressBookControlPanel controlPanel = new AddressBookControlPanel("My Contacts.txt");
        controlPanel.start();
    }
    }