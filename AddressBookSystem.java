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
            System.out.println("1.Add" + "\n" + "2.Edit" + "\n" + "3.Delete" + "\n" + "4.Multiple");
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
                case 4:
                    addressBookList.addmultipleContact();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    public void addContactDetails() {
        Contact details = new Contact();
        System.out.println("Enter a first name:");
        details.setFirstName(scanner.next());
        System.out.println("Enter a last name:");
        details.setLastName(scanner.next());
        System.out.println("Enter a Address:");
        details.setAddress(scanner.next());
        System.out.println("Enter a City name:");
        details.setCity(scanner.next());
        System.out.println("Enter a state:");
        details.setState(scanner.next());
        System.out.println("Enter a email:");
        details.setEmail(scanner.next());
        System.out.println("Enter a zip code:");
        details.setZip(scanner.nextInt());
        System.out.println("Enter a phone number:");
        details.setPhoneNumber(scanner.nextLong());

        addressBook.add(details);
        System.out.print(addressBook);
        System.out.println("Succesfully added new contacts");
    }

    public void editContactDetails() {
        System.out.println("Enter a name for edit:");
        String editName = scanner.next();
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getFirstName().equals(editName)) {
                System.out.println("select options");
                System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number\n8.Email");
                int editOption = scanner.nextInt();

                switch (editOption) {
                    case 1:
                        System.out.println("Enter a First name:");
                        String editFirstName = scanner.next();
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
        System.out.println("Confirm the name to delete contact");
        String confirmName = scanner.next();
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getFirstName().equals(confirmName)) ;
            Contact person = addressBook.get(i);
            addressBook.remove(person);
        }
        System.out.println(addressBook);
    }

    public void addmultipleContact() {
        System.out.println("Enter Number of Contacts to Add into Contact Book");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            addContactDetails();
            System.out.println(i + 1 + " Contact added Successfully.. ");
        }
    }

}
