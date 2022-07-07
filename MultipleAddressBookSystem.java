package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBookSystem {

    public static Map<String, AddressBookSystem> mapaddressbook = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome To AddressBook program");

        boolean condition = true;
        while (condition) {
            System.out.println("choose options \n1 : Add New AddressBook System \n2 : Add AddressBook System Contacts\n3 : Edit AddressBook System Contacts\n4 : Delete AddressBook System Contact\n5 : Add AddressBook System multiple contacts\n6 : Show Address Book details \n7 : Search By City Or State() \n8 : Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addAddressBook();
                    break;
                case 2:
                    addAddressBookContact();
                    break;
                case 3:
                    editAddressBookContact();
                    break;
                case 4:
                    deleteAddressBookContact();
                    break;
                case 5:
                    addMultipleContactsToAddressBook();
                    break;
                case 6:
                    showAddressBookDetails();
                case 7:
                    searchByCityOrState();
                case 8:
                    condition = false;
                    System.out.println("Exiting the loop ");
                    break;
                default:
                    condition = false;
                    System.out.println("Exiting the loop ");
            }
        }
    }


    public static void addAddressBook() {
        System.out.println("Create a New Address Book System !\nEnter the New AddressBook name :");
        String bookName = scanner.next();
        AddressBookSystem address = mapaddressbook.get(bookName);
        if(address == null){
            AddressBookSystem addressBook = new AddressBookSystem();
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
        AddressBookSystem address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if(address == null){
            System.out.println("No book found this name");
        }
        else{
            addressBookSystem.addContactDetails();
        }
    }

    public static void editAddressBookContact() {
        System.out.println("Enter Address Book System Name");
        String bookName = scanner.next();
        AddressBookSystem address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if(address == null){
            System.out.println("No book found this name");
        }
        else{
            addressBookSystem.editContactDetails();
        }
    }

    public static void deleteAddressBookContact() {
        System.out.println("Enter Address Book System Name");
        String bookName = scanner.next();
        AddressBookSystem address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if(address == null){
            System.out.println("No book found this name");
        }
        else{
            addressBookSystem.deleteContact();
        }
    }
    
    public static void addMultipleContactsToAddressBook() {
        System.out.println("Enter Address Book System Name");
        String bookName = scanner.next();
        AddressBookSystem address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if(address == null){
            System.out.println("No book found this name");
        }
        else{
            addressBookSystem.addmultipleContact();
        }
    }

    public static void showAddressBookDetails() {
        System.out.println("Enter Address Book System Name");
        String bookName = scanner.next();
        AddressBookSystem address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if(address == null){
            System.out.println("No book found this name");
        }
        else{
            addressBookSystem.showAddressBook();
        }
    }

    public static void searchByCityOrState() {
        System.out.println("Enter the AddressBookName ");
        String bookName = scanner.next();
        AddressBookSystem address = mapaddressbook.get(bookName);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        if (address == null) {
            System.out.println("No book found with these name");
        } else {
            addressBookSystem.searchMethod();
        }
    }
}