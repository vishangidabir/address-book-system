package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystem {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Contact> addressBook = new ArrayList<Contact>();
    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Problem !");
        AddressBookSystem addressBookList = new AddressBookSystem();
        addressBookList.addContactDetails();
    }
    public void addContactDetails(){
        Contact details=new Contact();
        System.out.println("Enter a first name:");
        details.setFirstName(scanner.next());
        String firstName = scanner.next();
        System.out.println("Enter a last name:");
        String lastName = scanner.next();
        details.setLastName(scanner.next());
        System.out.println("Enter a Address:");
        String address = scanner.next();
        details.setAddress(scanner.next());
        System.out.println("Enter a City name:");
        String city = scanner.next();
        details.setCity(scanner.next());
        System.out.println("Enter a state:");
        String state = scanner.next();
        details.setState(scanner.next());
        System.out.println("Enter a email:");
        String email = scanner.next();
        details.setEmail(scanner.next());
        System.out.println("Enter a zip code:");
        int zip = scanner.nextInt();
        details.setZip(scanner.nextInt());
        System.out.println("Enter a phone number:");
        long phoneNumber = scanner.nextLong();
        details.setPhoneNumber(scanner.nextLong());

        addressBook.add(details);
        Contact details1 = new Contact(firstName, lastName, address, city, state, email, zip, phoneNumber);
        addressBook.add(details1);
        System.out.print(addressBook);
        System.out.println("\nSuccesfully added new contact !");
    }
}