package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystem {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Contact> addressBook = new ArrayList<Contact>();

    public static void main(String[] args) {

        System.out.println("Welcome to the Address Book Problem");
        AddressBookSystem addressBookList = new AddressBookSystem();
        addressBookList.addContactDetails();
        boolean condition = true;

        while (condition == true) {
            System.out.println("1.add" + "\n" + "2.edit" + "\n" + "3.delete");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addressBookList.addContactDetails();
                    break;
                case 2:
                    addressBookList.editContactDetails();
                    break;
                case 3:
                    addressBookList.deleteContact();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
    public void addContactDetails() {
        Contact details=new Contact();
        System.out.println("Enter a first name:");
        String firstName=scanner.next();
        details.setFirstName(scanner.next());
        System.out.println("Enter a last name:");
        String lastName=scanner.next();
        details.setLastName(scanner.next());
        System.out.println("Enter a Address:");
        String address=scanner.next();
        details.setAddress(scanner.next());
        System.out.println("Enter a City name:");
        String city=scanner.next();
        details.setCity(scanner.next());
        System.out.println("Enter a state:");
        String state=scanner.next();
        details.setState(scanner.next());
        System.out.println("Enter a email:");
        String email=scanner.next();
        details.setEmail(scanner.next());
        System.out.println("Enter a zip code:");
        int  zip=scanner.nextInt();
        details.setZip(scanner.nextInt());
        System.out.println("Enter a phone number:");
        long phoneNumber=scanner.nextLong();
        details.setPhoneNumber(scanner.nextLong());

        addressBook.add(details);
        Contact details1=new Contact(firstName, lastName, address,  city, state, email,  zip, phoneNumber);
        addressBook.add(details1);
        System.out.print(addressBook);
        System.out.println("succesfully added person new contacts");
    }

    public void editContactDetails() {
        System.out.println("enter a name for edit:");
        String editName=scanner.next();
        for(int i=0; i<addressBook.size(); i++) {
            if(addressBook.get(i).getFirstName().equals(editName)) {
                System.out.println("select options");
                System.out.println("\n0.First Name\n1.Last Name\n2.Address\n3.City\n4.State\n5.Zip\n6.Phone Number");
                int editOption=scanner.nextInt();

                switch(editOption) {
                    case 1:
                        System.out.println("Enter a First name:");
                        String editFirstName=scanner.next();
                        addressBook.get(i).setFirstName(editFirstName);
                        System.out.println(editFirstName);
                        break;
                    case 2:
                        System.out.print("Enter a Last name:");
                        addressBook.get(i).setLastName(scanner.next());
                        break;
                    case 3:
                        System.out.print("Enter a Address:");
                        addressBook.get(i).setAddress(scanner.next());
                        break;
                    case 4:
                        System.out.print("Enter a city:");
                        addressBook.get(i).setCity(scanner.nextLine());
                        break;
                    case 5:
                        System.out.print("Enter a state:");
                        addressBook.get(i).setState(scanner.nextLine());
                        break;
                    case 6:
                        System.out.print("Enter a zip code:");
                        addressBook.get(i).setZip(scanner.nextInt());
                        break;
                    case 7:
                        System.out.print("Enter a phone number:");
                        addressBook.get(i).setPhoneNumber(scanner.nextLong());
                        break;
                    case 8:
                        System.out.print("Enter a email:");
                        addressBook.get(i).setEmail(scanner.nextLine());
                        break;
                    default:
                        System.out.println("enter valid contact");
                }
            }
            System.out.println("Edited list is:");
            System.out.println(addressBook);
        }
    }

    public void deleteContact() {
        System.out.println("confirm the name to delete contact");
        String confirmName=scanner.next();
        for (int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i).getFirstName().equals(confirmName));
            Contact person = addressBook.get(i);
            addressBook.remove(person);
        }
        System.out.println(addressBook);
    }
}
