package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddressBookSystem {
    public static Scanner scanner = new Scanner(System.in);

    public ArrayList<Contact> addContactDetails(ArrayList<Contact> contacts) {
        System.out.println("Please Enter the following details as below:");
        Contact details = new Contact();

        System.out.println("Enter a first name:");
        details.setFirstName(scanner.next());
        try {
            if (!validateFirstName(details.getFirstName()))
                System.out.println("Invalid ! Please Enter valid first name");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter a last name:");
        details.setLastName(scanner.next());
        try {
            if (!validateLastName(details.getLastName()))
                System.out.println("Invalid ! Please Enter valid last name");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter a Address:");
        details.setAddress(scanner.next());
        try{
        if (!validateAddress(details.getAddress()))
            System.out.println("Invalid ! Please Enter valid address");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter a City name:");
        details.setCity(scanner.next());
        try{
        if (!validateCity(details.getCity()))
            System.out.println("Invalid ! Please Enter valid city name");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter a State name :");
        details.setState(scanner.next());
        try{
        if (!validateState(details.getState()))
            System.out.println("Invalid ! Please Enter valid state name");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter a email:");
        details.setEmail(scanner.next());
        try{
        if(!validateEmail(details.getEmail()))
            System.out.println("Invalid ! Please Enter valid email");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter a zip code:");
        details.setZip(scanner.next());
        try{
        if(!validateZip(details.getZip()))
            System.out.println("Invalid ! Please Enter valid zip code");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enter a phone number:");
        details.setPhoneNumber(scanner.next());
        try{
        if(!validatePhoneNumber(details.getPhoneNumber()))
            System.out.println("Invalid ! Please Enter valid phone number");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        contacts.add(details);
        System.out.println("Succesfully added new contacts");
        return contacts;
    }

    private boolean validateFirstName(String firstname)  {
        return firstname.matches("[A-Z][a-z]{3,}");
    }
    private boolean validateLastName(String lastName) {
        return lastName.matches("[A-Z][a-z]{3,}");
    }
    private boolean validateAddress(String address) {
        return address.matches("[A-Z][a-z]{3,}");
    }
    private boolean validateCity(String city) {
        return city.matches("[A-Z][a-z]{3,}");
    }
    private boolean validateState(String state) {
        return state.matches("[A-Z][a-z]{3,}");
    }
    private boolean validateZip(String zip) {
        return zip.matches("[0-9]{6}");
    }
    private boolean validateEmail(String email)  {
        return email.matches("[a-z\\d]{5,}@[a-z]{5}.[a-z]{2,}");
    }
    private boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("(0/91)?[7-9][0-9]{9}");
    }

    public ArrayList<Contact> editContactDetails(ArrayList<Contact> contacts) {
        System.out.println("Enter a name for edit:");
        String editName = scanner.next();
        IntStream.range(0, contacts.size()).forEach(i -> {
            if (contacts.get(i).getFirstName().equals(editName)) {
                System.out.println("select options");
                System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number\n8.Email");
                int editOption = scanner.nextInt();

                switch (editOption) {
                    case 1 -> {
                        System.out.println("Enter a First name:");
                        String editFirstName = scanner.next();
                        contacts.get(i).setFirstName(editFirstName);
                        System.out.println(editFirstName);
                    }
                    case 2 -> {
                        System.out.print("Enter a Last name:");
                        contacts.get(i).setLastName(scanner.next());
                    }
                    case 3 -> {
                        System.out.print("Enter a Address:");
                        contacts.get(i).setAddress(scanner.next());
                    }
                    case 4 -> {
                        System.out.print("Enter a city:");
                        contacts.get(i).setCity(scanner.next());
                    }
                    case 5 -> {
                        System.out.print("Enter a state:");
                        contacts.get(i).setState(scanner.next());
                    }
                    case 6 -> {
                        System.out.print("Enter a zip code:");
                        contacts.get(i).setZip(scanner.next());
                    }
                    case 7 -> {
                        System.out.print("Enter a phone number:");
                        contacts.get(i).setPhoneNumber(scanner.next());
                    }
                    case 8 -> {
                        System.out.print("Enter a email:");
                        contacts.get(i).setEmail(scanner.next());
                    }
                    default -> System.out.println("enter valid contact");
                }
            }
            System.out.println(editName + " Edited Sucessfully");
        });
        return contacts;
    }

    public ArrayList<Contact> deleteContact(ArrayList<Contact> contacts) {
        System.out.println("Confirm the name to delete contact");
        String confirmName = scanner.next();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(confirmName)) ;
            Contact person = contacts.get(i);
            contacts.remove(person);
        }
        System.out.println(confirmName+" Deleted Sucessfully");
        return contacts;
    }

    public ArrayList<Contact> addmultipleContact(ArrayList<Contact> contacts) {
        System.out.println("Enter Number of Contacts to Add into Contact Book");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            contacts = addContactDetails(contacts);
            System.out.println(i + 1 + " Contact added Successfully.. ");
        }
        return contacts;
    }

    public void showAddressBook(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty");
        } else {
            Set<Contact> set = contacts.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Contact::toString))));
            set.forEach(System.out::println);
        }
    }

    public void searchByCity(ArrayList<Contact> contacts)  {
        System.out.println("Enter the city or state to search Contact ");
        String input = scanner.next();
        for (Contact book : contacts) {
            if (book.getCity().equals(input) || book.getState().equals(input)) {
                System.out.println("Matches with city name contact is :" + book);
            }
        }
    }
    public void countByCity(ArrayList<Contact> contacts) {
        System.out.println("Enter the city or state to search Contact ");
        AtomicInteger counter = new AtomicInteger(0);
        String input = scanner.next();
        contacts.forEach(i -> {if (i.getCity().equals(input)) {counter.getAndIncrement();}});
        System.out.println("number of contacts having city "+input+" are "+counter);
    }

    public void sortingByPerson(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("Contacts book is empty");
        } else {
            contacts.stream().sorted(Comparator.comparing(Contact::getFirstName)).forEach(System.out::println);
        }
    }

    public void sortingByCity(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("Contact book is empty");
        } else {
            contacts.stream().sorted(Comparator.comparing(Contact::getCity)).forEach(System.out::println);
        }
    }
}

