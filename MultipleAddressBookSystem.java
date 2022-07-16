package com.bridgelabz;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleAddressBookSystem {
    public static Map<String, ArrayList<Contact>> mapaddressbook = new HashMap<>();
    public static ArrayList<Contact> addressBook ;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("~~~~~~~~~Welcome To AddressBook System~~~~~~~~");

        boolean condition = true;
        while (condition) {
            System.out.println("\nchoose options \n1 : Add New System \n2 : Add Contact\n3 : Edit Contact\n4 : Delete Contact\n5 : Add multiple Contact\n6 : Show Contact\n7 : More Option \n8. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addAddressBook();
                case 2 -> addAddressBookContact();
                case 3 -> editAddressBookContact();
                case 4 -> deleteAddressBookContact();
                case 5 -> addMultipleContactsToAddressBook();
                case 6 -> showAddressBookDetails();
                case 7 -> moreOptions();
                case 8 -> {
                    condition = false;
                    System.out.println("Exiting the loop ");
                }
                default -> {
                    condition = false;
                    System.out.println("Exiting the loop ");
                }
            }
        }
    }

        public static void moreOptions() throws IOException {
        boolean condition = true;
        while (condition) {
            System.out.println("Choose the options\n1 : Search By City Or State name \n2 : Count By City Or State Name \n3 : Sort By Person Name \n4 : Sort By City Name \n5 : Read Person Details \n6 : Write Person Details \n7 : Exit ");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> searchByCityOrState(mapaddressbook);
                case 2 -> countByCityOrState(mapaddressbook);
                case 3 -> sortingByPersonName(mapaddressbook);
                case 4 -> sortingByCityName(mapaddressbook);
                case 5 -> readPersonDetails();
                case 6 -> writePersonDetails();
                case 7 -> {
                    condition = false;
                    System.out.println("Back To Main menu");
                }
                default -> System.out.println("Enter the correct option");
            }
        }
    }

    public static void addAddressBook() {
        System.out.println("Enter Your New Address Book Name :");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        if(address == null){
            addressBook = new ArrayList<>();
            mapaddressbook.put(bookName,addressBook);
            System.out.println(mapaddressbook.entrySet());
            System.out.println("SuccessFully added New AddressBook");
        }else{
            System.out.println("AddressBook with this name already exists");
        }
    }

    public static void addAddressBookContact() {
        System.out.println("Enter Address Book System Name");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if(address == null){
            System.out.println("No book found with this name");
        }
        else{
            address = addressBookSystem.addContactDetails(address);
        }
        mapaddressbook.put(bookName,address);
    }

    public static void editAddressBookContact() {
        System.out.println("Enter Address Book System Name");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if(address == null){
            System.out.println("No book found with this name");
        }
        else{
            address = addressBookSystem.editContactDetails(address);
        }
        mapaddressbook.put(bookName,address);
    }

    public static void deleteAddressBookContact() {
        System.out.println("Enter Address Book System Name");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if(address == null){
            System.out.println("No book found with this name");
        }
        else{
            address = addressBookSystem.deleteContact(address);
        }
        mapaddressbook.put(bookName,address);
    }
    
    public static void addMultipleContactsToAddressBook() {
        System.out.println("Enter Address Book System Name");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if(address == null){
            System.out.println("No book found with this name");
        }
        else{
            address = addressBookSystem.addmultipleContact(address);
        }
        mapaddressbook.put(bookName,address);
    }

    public static void showAddressBookDetails() {
        System.out.println("Enter Address Book System Name");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if(address == null){
            System.out.println("No book found with this name");
        }
        else{
            addressBookSystem.showAddressBook(address);
        }
    }

    public static void searchByCityOrState(Map<String, ArrayList<Contact>> mapaddressbook) {
        System.out.println("Enter the AddressBookName ");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if (address == null) {
            System.out.println("No book found with these name");
        } else {
            addressBookSystem.searchByCity(address);
        }
    }

    public static void countByCityOrState(Map<String, ArrayList<Contact>> mapaddressbook) {
        System.out.println("Enter the AddressBookName ");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if (address == null) {
            System.out.println("No book found with these name");
        } else {
            addressBookSystem.countByCity(address);
        }
    }
    public static void sortingByPersonName(Map<String, ArrayList<Contact>> mapaddressbook) {
        System.out.println("Enter the AddressBookName ");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if (address == null) {
            System.out.println("No book found with these name");
        } else {
            addressBookSystem.sortingByPerson(address);
        }
    }

    public static void sortingByCityName(Map<String, ArrayList<Contact>> mapaddressbook) {
        System.out.println("Enter the AddressBookName ");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if (address == null) {
            System.out.println("No book found with these name");
        } else {
            addressBookSystem.sortingByCity(address);
        }
    }

    private static void readPersonDetails() throws IOException {
        System.out.println("Enter AddressBook name ");
        String bookName = scanner.next();
            String path = "D:\\"+bookName+".txt";
                Files.newBufferedReader(Paths.get(path)).
                lines().
                collect(Collectors.toSet()).
                forEach(System.out::println);
    }

    private static void writePersonDetails() throws IOException {
        System.out.println("Enter AddressBook name ");
        String bookName = scanner.next();
        ArrayList<Contact> address = mapaddressbook.get(bookName);
        FileWriter writer = new FileWriter("D:\\"+bookName+".txt");
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        for(Contact str: address) {
            bufferWriter.write(str + System.lineSeparator());
        }
        bufferWriter.close();
        System.out.println("Success");
    }
}